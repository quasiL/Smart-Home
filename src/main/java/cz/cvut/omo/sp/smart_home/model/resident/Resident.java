package cz.cvut.omo.sp.smart_home.model.resident;

import cz.cvut.omo.sp.smart_home.model.Event;
import cz.cvut.omo.sp.smart_home.model.EventType;
import cz.cvut.omo.sp.smart_home.service.observer.EventListener;

public abstract class Resident implements EventListener
{
    private final String name;
    private final int age;

    protected Resident(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public Event createEvent()
    {
        return new Event(EventType.COLD, 2);
    }

    public void update(Event event) {}
}