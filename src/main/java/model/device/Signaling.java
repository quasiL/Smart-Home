package model.device;

import model.Event;
import service.HouseLogger;
import service.observer.EventListener;
import service.visitor.Visitor;

public class Signaling extends Device implements EventListener
{
    public Signaling(String name,
                     String manufacturer,
                     String firmwareVersion,
                     Battery battery,
                     NetworkSettings networkSettings,
                     int guarantee,
                     int room)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.SIGNALING, battery, networkSettings, guarantee, room);
    }

    @Override
    public void update(Event event)
    {
        HouseLogger.log("Device " + name + " get event " + event.getEventType());
        switch (event.getEventType()) {
            case HOUR_HAS_PASSED -> {
                if (isEnable()) {
                    increaseDeviceWear(0.05);
                    increaseElectricityConsumption(100);
                }
            }
            case FIRE -> {
                if (isEnable()) {
                    fireAlarm();
                    increaseDeviceWear(0.02);
                    increaseElectricityConsumption(265);
                }
            }
            case FLOOD -> {
                if (isEnable()) {
                    floodingAlarm();
                    increaseDeviceWear(0.02);
                    increaseElectricityConsumption(265);
                }
                setEnable(false);
            }
        }
    }

    @Override
    public String[] accept(Visitor visitor)
    {
        return visitor.visitSignaling(this);
    }

    /**
     * Method for signaling behavior on flood alarm
     */
    private void floodingAlarm()
    {
        HouseLogger.log("Flooding Alarm! The water in the house and all electrical were automatically shut off.");
    }

    /**
     * Method for signaling behavior on fire alarm
     */
    private void fireAlarm()
    {
        HouseLogger.log("Fire Alarm! I already called the fire department. Leave the house as soon as possible!");
    }
}