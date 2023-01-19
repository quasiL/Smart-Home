package cz.cvut.omo.sp.sh.service.builder;

import cz.cvut.omo.sp.sh.model.device.TemperatureSensor;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class TemperatureSensorBuilder extends BasicDeviceBuilder implements DeviceBuilder {
    /**
     * Method for creating new instance of TemperatureSensor
     *
     * @return new TemperatureSensor
     */
    public TemperatureSensor getResult() {
        HouseLogger.log("New " + name + " was created by TemperatureSensorBuilder");
        return new TemperatureSensor(name, manufacturer, firmwareVersion, battery, networkSettings, guarantee, room);
    }
}