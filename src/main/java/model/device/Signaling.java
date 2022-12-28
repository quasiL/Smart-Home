package model.device;

public class Signaling extends Device
{
    public Signaling(String name,
                     String manufacturer,
                     String firmwareVersion,
                     Battery battery,
                     NetworkSettings networkSettings,
                     int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.SIGNALING, battery, networkSettings, guarantee);
    }
}
