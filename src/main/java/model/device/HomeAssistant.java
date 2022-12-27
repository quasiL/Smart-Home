package model.device;

public class HomeAssistant extends Device
{
    public HomeAssistant(String name,
                         String manufacturer,
                         String firmwareVersion,
                         Battery battery,
                         NetworkSettings networkSettings,
                         int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.HOME_ASSISTANT, battery, networkSettings, guarantee);
    }
}
