package model.device;

public class SoundSystem extends Device
{
    public SoundSystem(String name,
                       String manufacturer,
                       String firmwareVersion,
                       Battery battery,
                       NetworkSettings networkSettings,
                       int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.SOUND_SYSTEM, battery, networkSettings, guarantee);
    }
}
