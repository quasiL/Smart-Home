package service.observer;

import model.Event;

public interface EventListener
{
    /**
     * Method for listener updating according to the Event
     * @param event event
     */
    void update(Event event);
}
