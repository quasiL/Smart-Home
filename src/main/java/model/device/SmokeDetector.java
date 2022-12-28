package model.device;

public class SmokeDetector extends Device
{
    public SmokeDetector(String name,
                         String manufacturer,
                         String firmwareVersion,
                         Battery battery,
                         NetworkSettings networkSettings,
                         int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.SMOKE_DETECTOR, battery, networkSettings, guarantee);
    }
}
