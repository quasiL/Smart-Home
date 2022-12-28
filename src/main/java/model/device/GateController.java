package model.device;

import model.gate.Door;
import model.gate.Window;
import service.strategy.Evening;
import service.strategy.Morning;
import service.strategy.Strategy;

public class GateController extends Device
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
                          int guarantee)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.GATE_CONTROLLER, battery, networkSettings, guarantee);
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
}
