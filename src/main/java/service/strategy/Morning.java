package service.strategy;

import model.gate.Door;
import model.gate.GateCondition;
import model.gate.Window;

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
    }

    @Override
    public void setBlindsPosition(Window window)
    {
        window.setPosition(120);
        window.setAutomatic(true);
    }
}