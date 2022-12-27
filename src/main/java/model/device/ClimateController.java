package model.device;

public class ClimateController extends Device
{
    public ClimateController(String name,
                             String manufacturer,
                             String firmwareVersion,
                             Battery battery,
                             NetworkSettings networkSettings,
                             int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.CLIMATE_CONTROLLER, battery, networkSettings, guarantee);
    }
}
