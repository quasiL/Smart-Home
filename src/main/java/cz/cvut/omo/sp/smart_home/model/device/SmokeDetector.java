package cz.cvut.omo.sp.smart_home.model.device;

import cz.cvut.omo.sp.smart_home.model.Event;
import cz.cvut.omo.sp.smart_home.service.HouseLogger;
import cz.cvut.omo.sp.smart_home.service.observer.EventListener;
import cz.cvut.omo.sp.smart_home.service.visitor.Visitor;

public class SmokeDetector extends Device implements EventListener
{
    public SmokeDetector(String name,
                         String manufacturer,
                         String firmwareVersion,
                         Battery battery,
                         NetworkSettings networkSettings,
                         int guarantee,
                         int room)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.SMOKE_DETECTOR, battery, networkSettings,
                guarantee, room);
    }

    @Override
    public void update(Event event)
    {
        HouseLogger.log("Device " + name + " get event " + event.getEventType());
        switch (event.getEventType()) {
            case HOUR_HAS_PASSED -> {
                if (isEnable()) {
                    increaseDeviceWear(0.01);
                    increaseElectricityConsumption(5);
                }
            }
            case FIRE -> {
                if (isEnable()) {
                    fireAlarm();
                    increaseDeviceWear(0.02);
                    increaseElectricityConsumption(265);
                }
            }
            case FLOOD -> setEnable(false);
            default -> HouseLogger.log("Device " + name + " unable to get this event.");
        }
    }

    @Override
    public String[] accept(Visitor visitor)
    {
        return visitor.visitSmokeDetector(this);
    }

    /**
     * Method for sensor behavior when smoke is detected
     */
    private void fireAlarm()
    {
        HouseLogger.log("The sensor " + getName() + " detected smoke in the room " + getRoom());
    }
}