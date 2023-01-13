package cz.cvut.omo.sp.smart_home.service.observer;

import cz.cvut.omo.sp.smart_home.model.Event;

public interface EventListener
{
    /**
     * Method for listener updating according to the Event
     * @param event event
     */
    void update(Event event);
}
