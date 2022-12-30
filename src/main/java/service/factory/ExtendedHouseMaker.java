package service.factory;

import model.EventType;
import model.Room;
import model.device.ClimateController;
import model.device.GateController;
import model.device.LightController;
import model.house.ExtendedHouse;
import model.resident.Animal;
import model.resident.Person;
import model.resident.Resident;
import service.builder.ClimateControllerBuilder;
import service.builder.GateControllerBuilder;
import service.builder.LightControllerBuilder;

import java.util.ArrayList;
import java.util.List;

public class ExtendedHouseMaker extends HouseMaker
{
    private final ExtendedHouse house;
    private final List<Resident> residents;
    private final GateControllerBuilder gateControllerBuilder;
    private final LightControllerBuilder lightControllerBuilder;
    private final ClimateControllerBuilder climateControllerBuilder;

    public ExtendedHouseMaker()
    {
        this.house = new ExtendedHouse();
        this.gateControllerBuilder = new GateControllerBuilder();
        this.lightControllerBuilder = new LightControllerBuilder();
        this.climateControllerBuilder = new ClimateControllerBuilder();

        residents = new ArrayList<>();
        residents.add(new Person("John", 45));
        residents.add(new Person("Mary", 42));
        residents.add(new Person("Rachel", 18));
        residents.add(new Person("Sophia", 12));
        residents.add(new Person("Michael", 5));
        residents.add(new Person("David", 1));
        residents.add(new Animal("Bella", 3, "Dog"));
        residents.add(new Animal("Charlie", 8, "Cat"));
        residents.add(new Animal("Luna", 3, "Hamster"));
    }

    @Override
    public ExtendedHouse createHouse()
    {
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
                    director.buildGateController(gateControllerBuilder, 0);
                    GateController gateController = gateControllerBuilder.getResult();
                    room.addDevice(gateController);
                    house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, gateController);
                    house.eventManager.subscribe(EventType.EVENING, gateController);
                    house.eventManager.subscribe(EventType.MORNING, gateController);
                    house.eventManager.subscribe(EventType.FLOOD, gateController);
                }

                director.buildLightController(lightControllerBuilder, i+j);
                LightController lightController = lightControllerBuilder.getResult();
                room.addDevice(lightController);
                house.eventManager.subscribe(EventType.HOUR_HAS_PASSED, lightController);
                house.eventManager.subscribe(EventType.MORNING, lightController);
                house.eventManager.subscribe(EventType.FLOOD, lightController);

                house.addRoom(room);
            }
        }
        return house;
    }
}
