package cz.cvut.omo.sp.sh.model.device;

import cz.cvut.omo.sp.sh.Config;
import cz.cvut.omo.sp.sh.model.Event;
import cz.cvut.omo.sp.sh.service.HouseLogger;
import cz.cvut.omo.sp.sh.service.observer.EventListener;
import cz.cvut.omo.sp.sh.service.visitor.Visitor;

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
        Config config = new Config();
        this.temperature = config.getTemperature();
    }

    @Override
    public void update(Event event)
    {
        HouseLogger.log("Device " + name + " get event " + event.getEventType());
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
            default -> HouseLogger.log("Device " + name + " unable to get this event.");
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
        HouseLogger.log("Temperature controller " + name + " set temperature to value " + temperature);
        increaseElectricityConsumption(10 * temperature);
        increaseDeviceWear(0.01);
    }

    @Override
    public String[] accept(Visitor visitor)
    {
        return visitor.visitClimateController(this);
    }
}