package cz.cvut.omo.sp.sh.model.resident;

import cz.cvut.omo.sp.sh.model.Event;
import cz.cvut.omo.sp.sh.model.EventType;
import cz.cvut.omo.sp.sh.service.observer.EventListener;

public abstract class Resident
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
}