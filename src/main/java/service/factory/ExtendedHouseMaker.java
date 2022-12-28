package service.factory;

import model.Room;
import model.device.ClimateController;
import model.device.GateController;
import model.device.LightController;
import model.house.ExtendedHouse;
import service.builder.ClimateControllerBuilder;
import service.builder.GateControllerBuilder;
import service.builder.LightControllerBuilder;

public class ExtendedHouseMaker extends HouseMaker
{
    private final ExtendedHouse house;
    private final GateControllerBuilder gateControllerBuilder;
    private final LightControllerBuilder lightControllerBuilder;
    private final ClimateControllerBuilder climateControllerBuilder;

    public ExtendedHouseMaker()
    {
        this.house = new ExtendedHouse();
        this.gateControllerBuilder = new GateControllerBuilder();
        this.lightControllerBuilder = new LightControllerBuilder();
        this.climateControllerBuilder = new ClimateControllerBuilder();
    }

    @Override
    public ExtendedHouse createHouse()
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
