package cz.cvut.omo.sp.smart_home.model.device;

import cz.cvut.omo.sp.smart_home.model.Event;
import cz.cvut.omo.sp.smart_home.model.gate.Door;
import cz.cvut.omo.sp.smart_home.model.gate.Window;
import cz.cvut.omo.sp.smart_home.service.HouseLogger;
import cz.cvut.omo.sp.smart_home.service.observer.EventListener;
import cz.cvut.omo.sp.smart_home.service.strategy.Evening;
import cz.cvut.omo.sp.smart_home.service.strategy.Morning;
import cz.cvut.omo.sp.smart_home.service.strategy.Strategy;
import cz.cvut.omo.sp.smart_home.service.visitor.Visitor;

public class GateController extends Device implements EventListener
{
    /**
     * Window in the room
     */
    private final Window window;

    /**
     * Door in the room
     */
    private final Door door;

    /**
     * Actual strategy
     */
    private Strategy strategy;

    /**
     * Evening strategy
     */
    private final Evening evening;

    /**
     * Morning strategy
     */
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

    /**
     * Method for changing actual strategy
     * @param strategy new strategy
     */
    private void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
        strategy.setBlindsPosition(window);
        strategy.setCondition(door, window);
        HouseLogger.log("Current gate strategy was changed to " + strategy.getClass().getSimpleName());
    }

    /**
     * Method for tests
     * @return Current strategy name
     */
    public String getStrategy()
    {
        return strategy.getClass().getSimpleName();
    }

    @Override
    public void update(Event event)
    {
        HouseLogger.log("Device " + name + " get event " + event.getEventType());
        switch (event.getEventType()) {
            case HOUR_HAS_PASSED -> {
                if (isEnable()) {
                    increaseDeviceWear(0.005);
                    increaseElectricityConsumption(700);
                }
            }

            case EVENING -> {
                setStrategy(evening);
                increaseDeviceWear(0.02);
                increaseElectricityConsumption(20);
            }

            case MORNING -> {
                setStrategy(morning);
                increaseDeviceWear(0.02);
                increaseElectricityConsumption(20);
            }

            case FLOOD -> setEnable(false);

            default -> HouseLogger.log("Device " + name + " unable to get this event.");
        }
    }

    @Override
    public String[] accept(Visitor visitor)
    {
        return visitor.visitGateController(this);
    }
}