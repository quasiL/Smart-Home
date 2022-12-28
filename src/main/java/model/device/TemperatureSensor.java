package model.device;

public class TemperatureSensor extends Device
{
    public TemperatureSensor(String name,
                             String manufacturer,
                             String firmwareVersion,
                             Battery battery,
                             NetworkSettings networkSettings,
                             int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.TEMPERATURE_SENSOR, battery, networkSettings, guarantee);
    }
}
