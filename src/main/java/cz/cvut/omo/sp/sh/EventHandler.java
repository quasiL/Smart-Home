package cz.cvut.omo.sp.sh;

import cz.cvut.omo.sp.sh.model.Event;
import cz.cvut.omo.sp.sh.model.EventType;
import cz.cvut.omo.sp.sh.service.observer.EventManager;

public class EventHandler {
    private EventManager eventManager;

    public EventHandler() {
        this.eventManager = new EventManager(EventType.values());
    }

    public void generateEvent(EventType type) {
        Event event = new Event(type);
        eventManager.notify(event);
    }

    public void generateEvent(EventType type, int room) {
        Event event = new Event(type, room);
        eventManager.notify(event);
    }

    public EventManager getEventManager() {
        return eventManager;
    }
}