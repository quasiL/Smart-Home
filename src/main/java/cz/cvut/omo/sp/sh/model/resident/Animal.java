package cz.cvut.omo.sp.sh.model.resident;

import cz.cvut.omo.sp.sh.model.Event;
import cz.cvut.omo.sp.sh.service.HouseLogger;
import cz.cvut.omo.sp.sh.service.observer.EventListener;

public class Animal extends Resident implements EventListener {
    private final String kindOfAnimal;
    private final boolean hunger;
    private int hoursWithoutFood;

    public Animal(String name, int age, String kindOfAnimal) {
        super(name, age);
        this.kindOfAnimal = kindOfAnimal;
        this.hunger = false;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    @Override
    public void update(Event event) {
        switch (event.getEventType()) {
            case HOUR_HAS_PASSED -> {
                HouseLogger.log(getKindOfAnimal() + " " + getName() + " get event " + event.getEventType());
                hoursWithoutFood++;
            }
            case ANIMAL_HUNGRY -> {
                HouseLogger.log(getKindOfAnimal() + " " + getName() + " get event " + event.getEventType());
                getFood();
            }
            case CHANGE_ACTION -> HouseLogger.log(getKindOfAnimal() + " " + getName() + " get event " + event.getEventType());

            default -> HouseLogger.log(getKindOfAnimal() + " " + getName() + " unable to get this event.");
        }
    }

    public boolean isHunger() {
        return hunger;
    }

    public int getHoursWithoutFood() {
        return hoursWithoutFood;
    }

    private void getFood() {
        HouseLogger.log(getKindOfAnimal() + getName() + " eats");
    }
}