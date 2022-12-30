package model.device;

import model.Event;
import model.EventType;
import service.observer.EventListener;

public class WaterController extends Device implements EventListener
{
    public WaterController(String name,
                           String manufacturer,
                           String firmwareVersion,
                           Battery battery,
                           NetworkSettings networkSettings,
                           int guarantee,
                           int room)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.WATER_CONTROLLER, battery, networkSettings, guarantee, room);
    }

    @Override
    public void update(Event event)
    {
        if (event.getEventType() == EventType.FLOOD) {
            setEnable(false);
        }
    }
}
