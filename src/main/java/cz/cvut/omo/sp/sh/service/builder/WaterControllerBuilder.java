package cz.cvut.omo.sp.sh.service.builder;

import cz.cvut.omo.sp.sh.model.device.WaterController;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class WaterControllerBuilder extends BasicDeviceBuilder implements DeviceBuilder
{
    /**
     * Method for creating new instance of WaterController
     * @return new WaterController
     */
    public WaterController getResult()
    {
        HouseLogger.log("New " + name + " was created by WaterControllerBuilder");
        return new WaterController(name, manufacturer, firmwareVersion, battery, networkSettings, guarantee, room);
    }
}