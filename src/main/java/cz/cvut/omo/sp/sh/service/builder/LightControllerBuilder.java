package cz.cvut.omo.sp.sh.service.builder;

import cz.cvut.omo.sp.sh.model.device.LightController;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class LightControllerBuilder extends BasicDeviceBuilder {
    /**
     * Method for creating new instance of LightController
     *
     * @return new LightController
     */
    public LightController getResult() {
        HouseLogger.log("New " + name + " was created by LightControllerBuilder");
        return new LightController(name, manufacturer, firmwareVersion, battery, networkSettings, guarantee, room);
    }
}