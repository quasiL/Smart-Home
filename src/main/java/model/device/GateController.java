package model.device;

public class GateController extends Device
{
    public GateController(String name,
                          String manufacturer,
                          String firmwareVersion,
                          Battery battery,
                          NetworkSettings networkSettings,
                          int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.GATE_CONTROLLER, battery, networkSettings, guarantee);
    }
}
