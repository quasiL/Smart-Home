package cz.cvut.omo.sp.sh.service.factory;

import cz.cvut.omo.sp.sh.model.EventType;
import cz.cvut.omo.sp.sh.model.Room;
import cz.cvut.omo.sp.sh.model.device.*;
import cz.cvut.omo.sp.sh.service.builder.*;
import cz.cvut.omo.sp.sh.model.house.ExtendedHouse;
import cz.cvut.omo.sp.sh.model.resident.Animal;
import cz.cvut.omo.sp.sh.model.resident.Person;
import cz.cvut.omo.sp.sh.model.resident.Resident;
import cz.cvut.omo.sp.sh.model.resident.TypeOfAction;
import cz.cvut.omo.sp.sh.service.HouseLogger;
import cz.cvut.omo.sp.sh.service.observer.EventListener;

import java.util.ArrayList;
import java.util.List;

public class ExtendedHouseMaker extends HouseMaker {
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

    public ExtendedHouseMaker() {
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
    public ExtendedHouse createHouse() {
        subscribeResidents();

        for (int i = 0; i < house.getNumberOfFloors(); i++) {
            for (int j = 0; j < house.getNumberOfRoomsPerFloor(); j++) {

                Room room;
                if (i + j == 3) {
                    room = new Room(residents);
                } else {
                    room = new Room();
                }

                house.addRoom(room);
            }
        }
        addMultipleDevices();
        HouseLogger.log("New ExtendedHouse was created by ExtendedHouseMaker");
        return house;
    }

    private void subscribeResidents() {
        for (Resident resident : residents) {
            house.getEventHandler().getEventManager().subscribe(EventType.HOUR_HAS_PASSED, (EventListener) resident);
            house.getEventHandler().getEventManager().subscribe(EventType.ANIMAL_HUNGRY, (EventListener) resident);
            house.getEventHandler().getEventManager().subscribe(EventType.CHANGE_ACTION, (EventListener) resident);
        }
    }

    private void subscribeSingleDevices(Device device) {
        switch (device.getType()) {
            case GATE_CONTROLLER -> {
                house.getEventHandler().getEventManager().subscribe(EventType.HOUR_HAS_PASSED, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.EVENING, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.MORNING, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.FLOOD, (EventListener) device);
            }
            case CLIMATE_CONTROLLER -> {
                house.getEventHandler().getEventManager().subscribe(EventType.HOUR_HAS_PASSED, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.WARM, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.COLD, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.FLOOD, (EventListener) device);
            }
            case SIGNALING -> {
                house.getEventHandler().getEventManager().subscribe(EventType.HOUR_HAS_PASSED, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.FIRE, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.FLOOD, (EventListener) device);
            }
            case SOUND_SYSTEM -> {
                house.getEventHandler().getEventManager().subscribe(EventType.HOUR_HAS_PASSED, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.SOUND_ON, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.SOUND_PAUSE, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.SOUND_RESUME, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.SOUND_NEXT_TRACK, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.SOUND_OFF, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.FLOOD, (EventListener) device);
            }
            default -> HouseLogger.log("Unhandled device");
        }
    }

    private void subscribeMultipleDevices(Device device) {
        switch (device.getType()) {
            case LIGHT_CONTROLLER -> {
                house.getEventHandler().getEventManager().subscribe(EventType.HOUR_HAS_PASSED, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.MORNING, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.FLOOD, (EventListener) device);
            }
            case WATER_CONTROLLER -> {
                house.getEventHandler().getEventManager().subscribe(EventType.HOUR_HAS_PASSED, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.FLOOD, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.WATER_ON, (EventListener) device);
            }
            case SMOKE_DETECTOR -> {
                house.getEventHandler().getEventManager().subscribe(EventType.HOUR_HAS_PASSED, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.FIRE, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.FLOOD, (EventListener) device);
            }
            case TEMPERATURE_SENSOR -> {
                house.getEventHandler().getEventManager().subscribe(EventType.HOUR_HAS_PASSED, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.WARM, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.COLD, (EventListener) device);
                house.getEventHandler().getEventManager().subscribe(EventType.FLOOD, (EventListener) device);
            }
            default -> HouseLogger.log("Unhandled device");
        }
    }

    private void addMultipleDevices() {
        for (int i = 0; i < house.getRooms().size(); i++) {

            if (i == 0) {
                director.buildGateController(gateControllerBuilder, 1);
                GateController gateController = gateControllerBuilder.getResult();
                house.getRooms().get(i).addDevice(gateController);
                subscribeSingleDevices(gateController);
            }
            if (i == 1) {
                director.buildClimateController(climateControllerBuilder, 0);
                ClimateController climateController = climateControllerBuilder.getResult();
                house.getRooms().get(i).addDevice(climateController);
                subscribeSingleDevices(climateController);
            }

            if (i == 2) {
                director.buildSignaling(signalingBuilder, 3);
                Signaling signaling = signalingBuilder.getResult();
                house.getRooms().get(i).addDevice(signaling);
                subscribeSingleDevices(signaling);
            }

            if (i == 3) {
                director.buildSoundSystem(soundSystemBuilder, 2);
                SoundSystem soundSystem = soundSystemBuilder.getResult();
                house.getRooms().get(i).addDevice(soundSystem);
                subscribeSingleDevices(soundSystem);
            }

            director.buildWaterController(waterControllerBuilder, i);
            WaterController waterController = waterControllerBuilder.getResult();
            house.getRooms().get(i).addDevice(waterController);
            subscribeMultipleDevices(waterController);

            director.buildLightController(lightControllerBuilder, i);
            LightController lightController = lightControllerBuilder.getResult();
            house.getRooms().get(i).addDevice(lightController);
            subscribeMultipleDevices(lightController);

            director.buildTemperatureSensor(temperatureSensorBuilder, i);
            TemperatureSensor temperatureSensor = temperatureSensorBuilder.getResult();
            house.getRooms().get(i).addDevice(temperatureSensor);
            subscribeMultipleDevices(temperatureSensor);

            director.buildSmokeDetector(smokeDetectorBuilder, i);
            SmokeDetector smokeDetector = smokeDetectorBuilder.getResult();
            house.getRooms().get(i).addDevice(smokeDetector);
            subscribeMultipleDevices(smokeDetector);
        }
    }
}