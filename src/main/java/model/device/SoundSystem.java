package model.device;

import model.Event;
import model.EventType;
import service.observer.EventListener;

public class SoundSystem extends Device implements EventListener
{
    public SoundSystem(String name,
                       String manufacturer,
                       String firmwareVersion,
                       Battery battery,
                       NetworkSettings networkSettings,
                       int guarantee,
                       int room)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.SOUND_SYSTEM, battery, networkSettings, guarantee, room);
    }

    @Override
    public void update(Event event)
    {
        if (event.getEventType() == EventType.FLOOD) {
            setEnable(false);
        }
    }
}
