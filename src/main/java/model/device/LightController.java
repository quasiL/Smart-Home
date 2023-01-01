package model.device;

import model.Event;
import service.HouseLogger;
import service.observer.EventListener;
import service.visitor.Visitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public String[] accept(Visitor visitor)
    {
        return visitor.visitLightController(this);
    }
}