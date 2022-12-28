package model.device;

public class WaterController extends Device
{
    public WaterController(String name,
                           String manufacturer,
                           String firmwareVersion,
                           Battery battery,
                           NetworkSettings networkSettings,
                           int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.WATER_CONTROLLER, battery, networkSettings, guarantee);
    }
}
