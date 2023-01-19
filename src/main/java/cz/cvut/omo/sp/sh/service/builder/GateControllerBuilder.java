package cz.cvut.omo.sp.sh.service.builder;

import cz.cvut.omo.sp.sh.model.device.GateController;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class GateControllerBuilder extends BasicDeviceBuilder {
    /**
     * Method for creating new instance of GateController
     *
     * @return new GateController
     */
    public GateController getResult() {
        HouseLogger.log("New " + name + " was created by GateControllerBuilder");
        return new GateController(name, manufacturer, firmwareVersion, battery, networkSettings, guarantee, room);
    }
}