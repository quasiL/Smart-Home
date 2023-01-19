package cz.cvut.omo.sp.sh.service.strategy;

import cz.cvut.omo.sp.sh.model.gate.Door;
import cz.cvut.omo.sp.sh.model.gate.GateCondition;
import cz.cvut.omo.sp.sh.model.gate.Window;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class Morning implements Strategy {
    @Override
    public void setCondition(Door door, Window window) {
        boolean doorChanged;
        boolean windowChanged;

        if (door.getCondition() == GateCondition.LOCKED || door.getCondition() == GateCondition.CLOSED) {
            door.setCondition(GateCondition.OPENED);
            doorChanged = true;
        } else {
            HouseLogger.log("Error: door has not changed its state.");
            doorChanged = false;
        }

        if (window.getCondition() == GateCondition.LOCKED || window.getCondition() == GateCondition.CLOSED) {
            window.setCondition(GateCondition.OPENED);
            windowChanged = true;
        } else {
            HouseLogger.log("Error: window has not changed its state.");
            windowChanged = false;
        }

        if (windowChanged && !doorChanged)
            HouseLogger.log("Window changed its state.");
        else if (!windowChanged && doorChanged)
            HouseLogger.log("Door changed its state.");
        else
            HouseLogger.log("Door and window changed their state");
    }

    @Override
    public void setBlindsPosition(Window window) {
        window.setPosition(120);
        window.setAutomatic(true);
    }
}