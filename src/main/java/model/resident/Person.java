package model.resident;

import model.Event;
import service.HouseLogger;

public class Person extends Resident
{
    private TypeOfAction action;

    public Person(String name, int age, TypeOfAction action)
    {
        super(name, age);
        this.action = action;
    }

    @Override
    public void update(Event event)
    {
        switch (event.getEventType()) {
            case CHANGE_ACTION -> setAction();
            case ANIMAL_HUNGRY -> feedAnimal();
        }
    }

    private void feedAnimal()
    {
        HouseLogger.log(getName() + " feeds animal");
    }

    public TypeOfAction getAction()
    {
        return action;
    }

    private void setAction()
    {
        if (this.action == TypeOfAction.REST) {
            this.action = TypeOfAction.SPORT;
            HouseLogger.log(getName() + " is currently exercising");
        } else {
            this.action = TypeOfAction.REST;
            HouseLogger.log(getName() + " is currently resting");
        }
    }
}