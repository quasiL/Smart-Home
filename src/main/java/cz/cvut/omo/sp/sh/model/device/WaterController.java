package cz.cvut.omo.sp.sh.model.device;

import cz.cvut.omo.sp.sh.model.Event;
import cz.cvut.omo.sp.sh.service.HouseLogger;
import cz.cvut.omo.sp.sh.service.observer.EventListener;
import cz.cvut.omo.sp.sh.service.visitor.Visitor;

public class WaterController extends Device implements EventListener {
    /**
     * Actual water consumption in the room
     */
    private int waterConsumptionInTheRoom;

    public WaterController(String name,
                           String manufacturer,
                           String firmwareVersion,
                           Battery battery,
                           NetworkSettings networkSettings,
                           int guarantee,
                           int room) {
        super(name, manufacturer, firmwareVersion, DeviceType.WATER_CONTROLLER, battery, networkSettings,
                guarantee, room);
        this.waterConsumptionInTheRoom = 0;
    }

    @Override
    public void update(Event event) {
        HouseLogger.log("Device " + name + " get event " + event.getEventType());
        switch (event.getEventType()) {
            case HOUR_HAS_PASSED -> {
                if (isEnable()) {
                    increaseDeviceWear(0.06);
                    increaseElectricityConsumption(250);
                }
            }
            case WATER_ON -> {
                if (isEnable()) {
                    waterConsumptionInTheRoom += 10;
                }
            }
            case FLOOD -> setEnable(false);
            default -> HouseLogger.log("Device " + name + " unable to get this event.");
        }
    }

    /**
     * Get actual water consumption in the room
     *
     * @return water consumption
     */
    public int getWaterConsumptionInTheRoom() {
        return waterConsumptionInTheRoom;
    }

    @Override
    public String[] accept(Visitor visitor) {
        return visitor.visitWaterController(this);
    }
}