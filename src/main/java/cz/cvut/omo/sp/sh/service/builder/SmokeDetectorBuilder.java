package cz.cvut.omo.sp.sh.service.builder;

import cz.cvut.omo.sp.sh.model.device.SmokeDetector;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class SmokeDetectorBuilder extends BasicDeviceBuilder
{
    /**
     * Method for creating new instance of SmokeDetector
     * @return new SmokeDetector
     */
    public SmokeDetector getResult()
    {
        HouseLogger.log("New " + name + " was created by SmokeDetectorBuilder");
        return new SmokeDetector(name, manufacturer, firmwareVersion, battery, networkSettings, guarantee, room);
    }
}