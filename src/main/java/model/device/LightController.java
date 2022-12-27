package model.device;

public class LightController extends Device
{
    public LightController(String name,
                           String manufacturer,
                           String firmwareVersion,
                           Battery battery,
                           NetworkSettings networkSettings,
                           int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.LIGHT_CONTROLLER, battery, networkSettings, guarantee);
    }
}
