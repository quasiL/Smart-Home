package cz.cvut.omo.sp.smart_home.model.resident;

import cz.cvut.omo.sp.smart_home.model.Event;
import cz.cvut.omo.sp.smart_home.service.HouseLogger;

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
        HouseLogger.log("Person " + getName() + " get event " + event.getEventType());
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