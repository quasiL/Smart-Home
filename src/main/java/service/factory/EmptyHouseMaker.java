package service.factory;

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

                Room room = new Room(false);

                director.buildClimateController(gateControllerBuilder);
                GateController gateController = gateControllerBuilder.getResult();
                room.addDevice(gateController);

                director.buildLightController(lightControllerBuilder);
                LightController lightController = lightControllerBuilder.getResult();
                room.addDevice(lightController);

                director.buildClimateController(climateControllerBuilder);
                ClimateController climateController = climateControllerBuilder.getResult();
                room.addDevice(climateController);

                house.addRoom(room);
            }
        }
        return house;
    }
}
