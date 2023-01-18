package cz.cvut.omo.sp.sh.service.builder;

import cz.cvut.omo.sp.sh.model.device.SoundSystem;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class SoundSystemBuilder extends BasicDeviceBuilder
{
    /**
     * Method for creating new instance of SoundSystem
     * @return new SoundSystem
     */
    public SoundSystem getResult()
    {
        HouseLogger.log("New " + name + " was created by SoundSystemBuilder");
        return new SoundSystem(name, manufacturer, firmwareVersion, battery, networkSettings, guarantee, room);
    }
}