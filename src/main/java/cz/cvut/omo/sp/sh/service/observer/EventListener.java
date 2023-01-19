package cz.cvut.omo.sp.sh.service.observer;

import cz.cvut.omo.sp.sh.model.Event;

public interface EventListener {
    /**
     * Method for listener updating according to the Event
     *
     * @param event event
     */
    void update(Event event);
}
