package cz.cvut.omo.sp.smart_home.service.factory;

import cz.cvut.omo.sp.smart_home.model.EventType;
import cz.cvut.omo.sp.smart_home.model.Room;
import cz.cvut.omo.sp.smart_home.model.device.*;
import cz.cvut.omo.sp.smart_home.service.builder.*;
import cz.cvut.omo.sp.smart_home.model.house.SimpleHouse;
import cz.cvut.omo.sp.smart_home.model.resident.Animal;
import cz.cvut.omo.sp.smart_home.model.resident.Person;
import cz.cvut.omo.sp.smart_home.model.resident.Resident;
import cz.cvut.omo.sp.smart_home.model.resident.TypeOfAction;
import cz.cvut.omo.sp.smart_home.service.HouseLogger;

import java.util.ArrayList;
import java.util.List;

public class SimpleHouseMaker extends HouseMaker
{
    private final SimpleHouse house;
    private final List<Resident> residents;
    private final GateControllerBuilder gateControllerBuilder;
    private final LightControllerBuilder lightControllerBuilder;
    private final ClimateControllerBuilder climateControllerBuilder;
    private final SignalingBuilder signalingBuilder;
    private final WaterControllerBuilder waterControllerBuilder;
    private final SmokeDetectorBuilder smokeDetectorBuilder;
    private final TemperatureSensorBuilder temperatureSensorBuilder;
    private final SoundSystemBuilder soundSystemBuilder;

    public SimpleHouseMaker()
    {
        this.house = new SimpleHouse();
        this.gateControllerBuilder = new GateControllerBuilder();
        this.lightControllerBuilder = new LightControllerBuilder();
        this.climateControllerBuilder = new ClimateControllerBuilder();
        this.signalingBuilder = new SignalingBuilder();
        this.waterControllerBuilder = new WaterControllerBuilder();
        this.smokeDetectorBuilder = new SmokeDetectorBuilder();
        this.temperatureSensorBuilder = new TemperatureSensorBuilder();
        this.soundSystemBuilder = new SoundSystemBuilder();

        residents = new ArrayList<>();
        residents.add(new Person("John", 45, TypeOfAction.SPORT));
        residents.add(new Person("Mary", 42, TypeOfAction.SPORT));
        residents.add(new Person("Rachel", 18, TypeOfAction.REST));
        residents.add(new Person("Sophia", 12, TypeOfAction.REST));
        residents.add(new Person("Michael", 5, TypeOfAction.REST));
        residents.add(new Person("David", 1, TypeOfAction.REST));
        residents.add(new Animal("Bella", 3, "Dog"));
        residents.add(new Animal("Charlie", 8, "Cat"));
        residents.add(new Animal("Luna", 3, "Hamster"));
    }

    @Override
    public SimpleHouse createHouse()
    {
        for (Resident resident : residents) {
            house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, resident);
            house.eventManager.subscribe(EventType.ANIMAL_HUNGRY, resident);
            house.eventManager.subscribe(EventType.CHANGE_ACTION, resident);
        }

        for (int i=0; i<house.getNumberOfFloors(); i++) {
            for (int j=0; j<house.getNumberOfRoomsPerFloor(); j++) {

                Room room;
                if (i+j == 0) {
                    room = new Room(residents);
                } else {
                    room = new Room();
                }

                if (i+j == 0) {
                    director.buildClimateController(climateControllerBuilder, 0);
                    ClimateController climateController = climateControllerBuilder.getResult();
                    room.addDevice(climateController);
                    house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, climateController);
                    house.eventManager.subscribe(EventType.WARM, climateController);
                    house.eventManager.subscribe(EventType.COLD, climateController);
                    house.eventManager.subscribe(EventType.FLOOD, climateController);
                }
                if (i+j == 1) {
                    director.buildGateController(gateControllerBuilder, 1);
                    GateController gateController = gateControllerBuilder.getResult();
                    room.addDevice(gateController);
                    house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, gateController);
                    house.eventManager.subscribe(EventType.EVENING, gateController);
                    house.eventManager.subscribe(EventType.MORNING, gateController);
                    house.eventManager.subscribe(EventType.FLOOD, gateController);
                }

                if (i+j == 2) {
                    director.buildSoundSystem(soundSystemBuilder, 2);
                    SoundSystem soundSystem = soundSystemBuilder.getResult();
                    room.addDevice(soundSystem);
                    house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, soundSystem);
                    house.eventManager.subscribe(EventType.SOUND_ON, soundSystem);
                    house.eventManager.subscribe(EventType.SOUND_PAUSE, soundSystem);
                    house.eventManager.subscribe(EventType.SOUND_RESUME, soundSystem);
                    house.eventManager.subscribe(EventType.SOUND_NEXT_TRACK, soundSystem);
                    house.eventManager.subscribe(EventType.SOUND_OFF, soundSystem);
                    house.eventManager.subscribe(EventType.FLOOD, soundSystem);
                }

                if (i+j == 3) {
                    director.buildSignaling(signalingBuilder, 3);
                    Signaling signaling = signalingBuilder.getResult();
                    room.addDevice(signaling);
                    house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, signaling);
                    house.eventManager.subscribe(EventType.FIRE, signaling);
                    house.eventManager.subscribe(EventType.FLOOD, signaling);
                }

                director.buildLightController(lightControllerBuilder, i+j);
                LightController lightController = lightControllerBuilder.getResult();
                room.addDevice(lightController);
                house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, lightController);
                house.eventManager.subscribe(EventType.MORNING, lightController);
                house.eventManager.subscribe(EventType.FLOOD, lightController);

                director.buildWaterController(waterControllerBuilder, i+j);
                WaterController waterController = waterControllerBuilder.getResult();
                room.addDevice(waterController);
                house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, waterController);
                house.eventManager.subscribe(EventType.FLOOD, waterController);
                house.eventManager.subscribe(EventType.WATER_ON, waterController);

                director.buildSmokeDetector(smokeDetectorBuilder, i+j);
                SmokeDetector smokeDetector = smokeDetectorBuilder.getResult();
                room.addDevice(smokeDetector);
                house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, smokeDetector);
                house.eventManager.subscribe(EventType.FIRE, smokeDetector);
                house.eventManager.subscribe(EventType.FLOOD, smokeDetector);

                director.buildTemperatureSensor(temperatureSensorBuilder, i+j);
                TemperatureSensor temperatureSensor = temperatureSensorBuilder.getResult();
                room.addDevice(temperatureSensor);
                house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, temperatureSensor);
                house.eventManager.subscribe(EventType.WARM, temperatureSensor);
                house.eventManager.subscribe(EventType.COLD, temperatureSensor);
                house.eventManager.subscribe(EventType.FLOOD, temperatureSensor);

                house.addRoom(room);
            }
        }
        HouseLogger.log("New SimpleHouse was created by SimpleHouseMaker");
        return house;
    }
}