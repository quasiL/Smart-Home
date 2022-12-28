package service.strategy;

import model.gate.Door;
import model.gate.Window;

public interface Strategy
{
    void setCondition(Door door, Window window);

    void setBlindsPosition(Window window);
}
