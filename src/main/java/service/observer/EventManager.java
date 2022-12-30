package service.observer;

import model.Event;
import model.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager
{
    Map<EventType, List<EventListener>> listeners = new HashMap<>();

    public EventManager(EventType... events)
    {
        for (EventType event : events) {
            this.listeners.put(event, new ArrayList<>());
        }
    }

    public void subscribe(EventType event, EventListener listener)
    {
        List<EventListener> users = listeners.get(event);
        users.add(listener);
    }

    public void unsubscribe(EventType event, EventListener listener)
    {
        List<EventListener> users = listeners.get(event);
        users.remove(listener);
    }

    public void notify(Event event)
    {
        List<EventListener> users = listeners.get(event.getEventType());
        for (EventListener listener : users) {
            listener.update(event);
        }
    }
}
