package model.device;

import model.Event;
import service.observer.EventListener;
import service.visitor.Visitor;

public class ClimateController extends Device implements EventListener
{
    /**
     * Actual temperature in the house
     */
    private int temperature;

    public ClimateController(String name,
                             String manufacturer,
                             String firmwareVersion,
                             Battery battery,
                             NetworkSettings networkSettings,
                             int guarantee,
                             int room)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.CLIMATE_CONTROLLER, battery, networkSettings,
                guarantee, room);
        this.temperature = 18;
    }

    @Override
    public void update(Event event)
    {
        switch (event.getEventType()) {
            case HOUR_HAS_PASSED -> {
                if (isEnable()) {
                    increaseDeviceWear(0.05);
                    increaseElectricityConsumption(1000);
                }
            }
            case WARM -> {
                setTemperature(-2);
                increaseDeviceWear(0.02);
                increaseElectricityConsumption(15);
            }
            case COLD -> {
                setTemperature(2);
                increaseDeviceWear(0.02);
                increaseElectricityConsumption(15);
            }
            case FLOOD -> setEnable(false);
        }
    }

    /**
     * Get actual temperature in the house
     * @return temperature
     */
    public int getTemperature()
    {
        return temperature;
    }

    /**
     * Method for increasing/decreasing temperature in the house
     * @param temperature temperature change
     */
    public void setTemperature(int temperature)
    {
        this.temperature += temperature;
        increaseElectricityConsumption(10 * temperature);
        increaseDeviceWear(0.01);
    }

    @Override
    public String[] accept(Visitor visitor)
    {
        return visitor.visitClimateController(this);
    }
}