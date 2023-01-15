package cz.cvut.omo.sp.smart_home.model.device;

import cz.cvut.omo.sp.smart_home.model.Event;
import cz.cvut.omo.sp.smart_home.service.HouseLogger;
import cz.cvut.omo.sp.smart_home.service.observer.EventListener;
import cz.cvut.omo.sp.smart_home.service.visitor.Visitor;

public class LightController extends Device implements EventListener
{
    /**
     * The state of the light in the room
     */
    private boolean lightInTheRoom;

    public LightController(String name,
                           String manufacturer,
                           String firmwareVersion,
                           Battery battery,
                           NetworkSettings networkSettings,
                           int guarantee,
                           int room)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.LIGHT_CONTROLLER, battery, networkSettings,
                guarantee, room);
        lightInTheRoom = false;
    }

    @Override
    public void update(Event event)
    {
        HouseLogger.log("Device " + name + " get event " + event.getEventType());
        switch (event.getEventType()) {
            case HOUR_HAS_PASSED -> {
                if (isEnable()) {
                    increaseDeviceWear(0.02);
                    increaseElectricityConsumption(300);
                }
            }
            case MORNING -> setLightInTheRoom(false);
            case FLOOD -> setEnable(false);
            default -> HouseLogger.log("Device " + name + " unable to get this event.");
        }
    }

    /**
     * On/off the light
     * @param newState on/off
     */
    public void setLightInTheRoom(boolean newState)
    {
        HouseLogger.log("Light controller " + name + " set light at the room " + room + " to value " + newState);
        if (lightInTheRoom != newState) {
            lightInTheRoom = newState;
            increaseDeviceWear(0.01);
            increaseElectricityConsumption(5);
        }
    }

    @Override
    public String[] accept(Visitor visitor)
    {
        return visitor.visitLightController(this);
    }
}