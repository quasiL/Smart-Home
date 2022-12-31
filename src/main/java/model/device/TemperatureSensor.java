package model.device;

import model.Event;
import service.HouseLogger;
import service.observer.EventListener;
import service.visitor.Visitor;

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
        super(name, manufacturer, firmwareVersion, DeviceType.TEMPERATURE_SENSOR, battery, networkSettings,
                guarantee, room);
    }

    @Override
    public void update(Event event)
    {
        switch (event.getEventType()) {
            case HOUR_HAS_PASSED -> {
                if (isEnable()) {
                    increaseDeviceWear(0.01);
                    increaseElectricityConsumption(10);
                }
            }
            case WARM -> {
                warmDetection();
                increaseDeviceWear(0.02);
                increaseElectricityConsumption(15);
            }
            case COLD -> {
                coldDetection();
                increaseDeviceWear(0.02);
                increaseElectricityConsumption(15);
            }
            case FLOOD -> setEnable(false);
        }
    }

    @Override
    public String[] accept(Visitor visitor)
    {
        return visitor.visitTemperatureSensor(this);
    }

    /**
     * Method for the behavior of the sensor when the temperature in the room rises
     */
    private void warmDetection()
    {
        HouseLogger.log("The sensor " + getName() + " detected an increase in temperature in the room " + getRoom());
    }

    /**
     * Method for the behavior of the sensor when the temperature in the room drops
     */
    private void coldDetection()
    {
        HouseLogger.log("The sensor " + getName() + " detected an decrease in temperature in the room " + getRoom());
    }
}