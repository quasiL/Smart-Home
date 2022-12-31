package model.resident;

import model.Event;
import service.HouseLogger;

public class Animal extends Resident
{
    private final String kindOfAnimal;
    private boolean hunger;
    private int hoursWithoutFood;

    public Animal(String name, int age, String kindOfAnimal)
    {
        super(name, age);
        this.kindOfAnimal = kindOfAnimal;
        this.hunger = false;
    }

    public String getKindOfAnimal()
    {
        return kindOfAnimal;
    }

    @Override
    public void update(Event event)
    {
        switch (event.getEventType()) {
            case HOUR_HAS_PASSED -> hoursWithoutFood++;
            case ANIMAL_HUNGRY -> getFood();
        }
    }

    public boolean isHunger()
    {
        return hunger;
    }

    public int getHoursWithoutFood()
    {
        return hoursWithoutFood;
    }

    private void getFood()
    {
        HouseLogger.log(getKindOfAnimal() + getName() + " eats");
    }
}