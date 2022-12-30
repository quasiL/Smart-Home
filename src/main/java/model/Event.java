package model;

public class Event
{
    private final EventType eventType;
    private final int room;

    public Event(EventType eventType, int room)
    {
        this.eventType = eventType;
        this.room = room;
    }

    public Event(EventType eventType)
    {
        this.eventType = eventType;
        this.room = -1;
    }

    public EventType getEventType()
    {
        return eventType;
    }

    public int getRoom()
    {
        return room;
    }
}
