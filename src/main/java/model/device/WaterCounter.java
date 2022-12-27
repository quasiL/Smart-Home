package model.device;

public class WaterCounter extends Device
{
    public WaterCounter(String name,
                        String manufacturer,
                        String firmwareVersion,
                        Battery battery,
                        NetworkSettings networkSettings,
                        int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.WATER_COUNTER, battery, networkSettings, guarantee);
    }
}
