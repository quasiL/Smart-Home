package cz.cvut.omo.sp.sh.service.observer;

import cz.cvut.omo.sp.sh.model.Event;
import cz.cvut.omo.sp.sh.model.EventType;
import cz.cvut.omo.sp.sh.service.HouseLogger;

import java.util.*;

public class EventManager
{
    /**
     * HashMap listener - events
     */
    Map<EventType, List<EventListener>> listeners = new EnumMap<>(EventType.class);

    public EventManager(EventType... events)
    {
        HouseLogger.log("EventManager for the house was created");
        for (EventType event : events) {
            this.listeners.put(event, new ArrayList<>());
        }
    }

    /**
     * Method for adding listener to this type of event
     * @param event event
     * @param listener new listener
     */
    public void subscribe(EventType event, EventListener listener)
    {
        List<EventListener> users = listeners.get(event);
        users.add(listener);
    }

    /**
     * Method for removing listener from this type of event
     * @param event event
     * @param listener listener
     */
    public void unsubscribe(EventType event, EventListener listener)
    {
        List<EventListener> users = listeners.get(event);
        users.remove(listener);
    }

    /**
     * Method for notifying listeners about this type of event
     * @param event current event
     */
    public void notify(Event event)
    {
        HouseLogger.log("All relevant listeners have been notified of the event " + event.getEventType());
        List<EventListener> users = listeners.get(event.getEventType());
        for (EventListener listener : users) {
            listener.update(event);
        }
    }
}