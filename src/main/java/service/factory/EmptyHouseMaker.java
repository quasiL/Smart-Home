package service.factory;

import model.EventType;
import model.Room;
import model.device.ClimateController;
import model.device.GateController;
import model.device.LightController;
import model.house.EmptyHouse;
import service.builder.ClimateControllerBuilder;
import service.builder.GateControllerBuilder;
import service.builder.LightControllerBuilder;

public class EmptyHouseMaker extends HouseMaker
{
    private final EmptyHouse house;
    private final GateControllerBuilder gateControllerBuilder;
    private final LightControllerBuilder lightControllerBuilder;
    private final ClimateControllerBuilder climateControllerBuilder;

    public EmptyHouseMaker()
    {
        this.house = new EmptyHouse();
        this.gateControllerBuilder = new GateControllerBuilder();
        this.lightControllerBuilder = new LightControllerBuilder();
        this.climateControllerBuilder = new ClimateControllerBuilder();
    }

    @Override
    public EmptyHouse createHouse()
    {
        for (int i=0; i<house.getNumberOfFloors(); i++) {
            for (int j=0; j<house.getNumberOfRoomsPerFloor(); j++) {

                Room room = new Room();

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
