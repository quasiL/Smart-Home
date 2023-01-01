package service.observer;

import model.Event;
import model.EventType;
import service.HouseLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager
{
    /**
     * HashMap listener - events
     */
    Map<EventType, List<EventListener>> listeners = new HashMap<>();

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