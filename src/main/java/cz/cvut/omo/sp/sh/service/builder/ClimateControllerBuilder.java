package cz.cvut.omo.sp.sh.service.builder;

import cz.cvut.omo.sp.sh.model.device.ClimateController;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class ClimateControllerBuilder extends BasicDeviceBuilder {
    /**
     * Method for creating new instance of ClimateController
     *
     * @return new ClimateController
     */
    public ClimateController getResult() {
        HouseLogger.log("New " + name + " was created by ClimateControllerBuilder");
        return new ClimateController(name, manufacturer, firmwareVersion, battery, networkSettings, guarantee, room);
    }
}