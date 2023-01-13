package cz.cvut.omo.sp.smart_home.service.strategy;

import cz.cvut.omo.sp.smart_home.model.gate.Door;
import cz.cvut.omo.sp.smart_home.model.gate.GateCondition;
import cz.cvut.omo.sp.smart_home.model.gate.Window;
import cz.cvut.omo.sp.smart_home.service.HouseLogger;

public class Morning implements Strategy
{
    @Override
    public void setCondition(Door door, Window window)
    {
        switch (door.getCondition()) {
            case LOCKED, CLOSED -> door.setCondition(GateCondition.OPENED);
        }
        switch (window.getCondition()) {
            case LOCKED, CLOSED -> door.setCondition(GateCondition.OPENED);
        }
        HouseLogger.log("Door and window changed their state");
    }

    @Override
    public void setBlindsPosition(Window window)
    {
        window.setPosition(120);
        window.setAutomatic(true);
    }
}