package model.device;

import model.Event;
import service.observer.EventListener;

public class ClimateController extends Device implements EventListener
{
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
                    increaseElectricityConsuming(1000);
                }
            }
            case WARM -> {
                setTemperature(-2);
                increaseDeviceWear(0.02);
                increaseElectricityConsuming(15);
            }
            case COLD -> {
                setTemperature(2);
                increaseDeviceWear(0.02);
                increaseElectricityConsuming(15);
            }
            case FLOOD -> setEnable(false);
        }
    }

    public int getTemperature()
    {
        return temperature;
    }

    public void setTemperature(int temperature)
    {
        this.temperature += temperature;
        increaseElectricityConsuming(10 * temperature);
        increaseDeviceWear(0.01);
    }
}
