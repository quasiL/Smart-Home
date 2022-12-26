package model.resident;

import model.Event;

public abstract class Resident
{
    private final String name;
    private final int age;

    public Resident(String name, int age)
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
        return new Event();
    }
}