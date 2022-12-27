package model.device;

public class CarDiagnostic extends Device
{
    public CarDiagnostic(String name,
                         String manufacturer,
                         String firmwareVersion,
                         Battery battery,
                         NetworkSettings networkSettings,
                         int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.CAR_DIAGNOSTIC, battery, networkSettings, guarantee);
    }
}
