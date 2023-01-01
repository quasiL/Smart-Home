package service.strategy;

import model.gate.Door;
import model.gate.Window;

public interface Strategy
{
    /**
     * Method for strategy changing door and window parameters
     * @param door door
     * @param window window
     */
    void setCondition(Door door, Window window);

    /**
     * Method for strategy changing window blinds parameters
     * @param window window
     */
    void setBlindsPosition(Window window);
}