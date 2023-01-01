package service.factory;

import model.EventType;
import model.Room;
import model.device.*;
import model.house.ExtendedHouse;
import model.resident.Animal;
import model.resident.Person;
import model.resident.Resident;
import model.resident.TypeOfAction;
import service.HouseLogger;
import service.builder.*;

import java.util.ArrayList;
import java.util.List;

public class ExtendedHouseMaker extends HouseMaker
{
    private final ExtendedHouse house;
    private final List<Resident> residents;
    private final GateControllerBuilder gateControllerBuilder;
    private final LightControllerBuilder lightControllerBuilder;
    private final ClimateControllerBuilder climateControllerBuilder;
    private final SignalingBuilder signalingBuilder;
    private final WaterControllerBuilder waterControllerBuilder;
    private final SmokeDetectorBuilder smokeDetectorBuilder;
    private final TemperatureSensorBuilder temperatureSensorBuilder;
    private final SoundSystemBuilder soundSystemBuilder;

    public ExtendedHouseMaker()
    {
        this.house = new ExtendedHouse();
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
    public ExtendedHouse createHouse()
    {
        for (Resident resident : residents) {
            house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, resident);
            house.eventManager.subscribe(EventType.ANIMAL_HUNGRY, resident);
            house.eventManager.subscribe(EventType.CHANGE_ACTION, resident);
        }

        for (int i=0; i<house.getNumberOfFloors(); i++) {
            for (int j=0; j<house.getNumberOfRoomsPerFloor(); j++) {

                Room room;
                if (i+j == 3) {
                    room = new Room(residents);
                } else {
                    room = new Room();
                }

                if (i+j == 0) {
                    director.buildGateController(gateControllerBuilder, 0);
                    GateController gateController = gateControllerBuilder.getResult();
                    room.addDevice(gateController);
                    house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, gateController);
                    house.eventManager.subscribe(EventType.EVENING, gateController);
                    house.eventManager.subscribe(EventType.MORNING, gateController);
                    house.eventManager.subscribe(EventType.FLOOD, gateController);
                }
                if (i+j == 1) {
                    director.buildClimateController(climateControllerBuilder, 1);
                    ClimateController climateController = climateControllerBuilder.getResult();
                    room.addDevice(climateController);
                    house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, climateController);
                    house.eventManager.subscribe(EventType.WARM, climateController);
                    house.eventManager.subscribe(EventType.COLD, climateController);
                    house.eventManager.subscribe(EventType.FLOOD, climateController);
                }

                if (i+j == 2) {
                    director.buildSignaling(signalingBuilder, 2);
                    Signaling signaling = signalingBuilder.getResult();
                    room.addDevice(signaling);
                    house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, signaling);
                    house.eventManager.subscribe(EventType.FIRE, signaling);
                    house.eventManager.subscribe(EventType.FLOOD, signaling);
                }

                if (i+j == 3) {
                    director.buildSoundSystem(soundSystemBuilder, 3);
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
        HouseLogger.log("New ExtendedHouse was created by ExtendedHouseMaker");
        return house;
    }
}