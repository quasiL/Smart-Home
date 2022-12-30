package model.device;

import model.Event;
import model.EventType;
import service.observer.EventListener;

public class TemperatureSensor extends Device implements EventListener
{
    public TemperatureSensor(String name,
                             String manufacturer,
                             String firmwareVersion,
                             Battery battery,
                             NetworkSettings networkSettings,
                             int guarantee,
                             int room)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.TEMPERATURE_SENSOR, battery, networkSettings, guarantee, room);
    }

    @Override
    public void update(Event event)
    {
        if (event.getEventType() == EventType.FLOOD) {
            setEnable(false);
        }
    }
}
