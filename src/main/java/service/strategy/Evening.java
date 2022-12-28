package service.strategy;

import model.gate.Door;
import model.gate.GateCondition;
import model.gate.Window;

public class Evening implements Strategy
{
    @Override
    public void setCondition(Door door, Window window)
    {
        switch (door.getCondition()) {
            case OPENED, CLOSED -> door.setCondition(GateCondition.LOCKED);
        }
        switch (window.getCondition()) {
            case OPENED, CLOSED -> door.setCondition(GateCondition.LOCKED);
        }
    }

    @Override
    public void setBlindsPosition(Window window)
    {
        window.setPosition(60);
        window.setAutomatic(false);
    }
}