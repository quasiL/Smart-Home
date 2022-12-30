package model.device;

import model.Event;
import model.gate.Door;
import model.gate.Window;
import service.observer.EventListener;
import service.strategy.Evening;
import service.strategy.Morning;
import service.strategy.Strategy;

public class GateController extends Device implements EventListener
{
    private final Window window;
    private final Door door;
    private Strategy strategy;
    private final Evening evening;
    private final Morning morning;

    public GateController(String name,
                          String manufacturer,
                          String firmwareVersion,
                          Battery battery,
                          NetworkSettings networkSettings,
                          int guarantee,
                          int room)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.GATE_CONTROLLER, battery, networkSettings,
                guarantee, room);
        this.window = new Window();
        this.door = new Door();
        this.evening = new Evening();
        this.morning = new Morning();
        this.strategy = morning;
    }

    private void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
        strategy.setBlindsPosition(window);
        strategy.setCondition(door, window);
    }

    /**
     * Method for tests
     * @return Strategy name
     */
    public String getStrategy()
    {
        return strategy.getClass().getName();
    }

    @Override
    public void update(Event event)
    {
        switch (event.getEventType()) {
            case HOUR_HAS_PASSED -> {
                if (isEnable()) {
                    increaseDeviceWear(0.05);
                    increaseElectricityConsuming(700);
                }
            }
            case EVENING -> {
                setStrategy(evening);
                increaseDeviceWear(0.02);
                increaseElectricityConsuming(20);
            }
            case MORNING -> {
                setStrategy(morning);
                increaseDeviceWear(0.02);
                increaseElectricityConsuming(20);
            }
            case FLOOD -> setEnable(false);
        }
    }
}
