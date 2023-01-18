package cz.cvut.omo.sp.sh.service.builder;

import cz.cvut.omo.sp.sh.model.device.Signaling;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class SignalingBuilder extends BasicDeviceBuilder
{
    /**
     * Method for creating new instance of Signaling
     * @return new Signaling
     */
    public Signaling getResult()
    {
        HouseLogger.log("New " + name + " was created by SignalingBuilder");
        return new Signaling(name, manufacturer, firmwareVersion, battery, networkSettings, guarantee, room);
    }
}