package cz.cvut.omo.sp.sh.service.factory;

import cz.cvut.omo.sp.sh.model.EventType;
import cz.cvut.omo.sp.sh.model.Room;
import cz.cvut.omo.sp.sh.model.house.EmptyHouse;
import cz.cvut.omo.sp.sh.model.resident.Animal;
import cz.cvut.omo.sp.sh.model.resident.Person;
import cz.cvut.omo.sp.sh.model.resident.Resident;
import cz.cvut.omo.sp.sh.model.resident.TypeOfAction;
import cz.cvut.omo.sp.sh.service.HouseLogger;
import cz.cvut.omo.sp.sh.service.observer.EventListener;

import java.util.ArrayList;
import java.util.List;

public class EmptyHouseMaker extends HouseMaker
{
    private final EmptyHouse house;
    private final List<Resident> residents;

    public EmptyHouseMaker()
    {
        this.house = new EmptyHouse();

        residents = new ArrayList<>();
        residents.add(new Person("John", 45, TypeOfAction.SPORT));
        residents.add(new Person("Mary", 42, TypeOfAction.SPORT));
        residents.add(new Person("Rachel", 18, TypeOfAction.REST));
        residents.add(new Person("Sophia", 12, TypeOfAction.REST));
        residents.add(new Person("Michael", 5, TypeOfAction.REST));
        residents.add(new Person("David", 1, TypeOfAction.REST));
        residents.add(new Animal("Bella", 3, "Dog"));
        residents.add(new Animal("Charlie", 8, "Cat"));
        residents.add(new Animal("Luna", 3, "Hamster"));
    }

    @Override
    public EmptyHouse createHouse()
    {
        for (Resident resident : residents) {
            house.getEventHandler().getEventManager().subscribe(EventType.HOUR_HAS_PASSED, (EventListener)resident);
            house.getEventHandler().getEventManager().subscribe(EventType.ANIMAL_HUNGRY, (EventListener)resident);
            house.getEventHandler().getEventManager().subscribe(EventType.CHANGE_ACTION, (EventListener)resident);
        }

        for (int i=0; i<house.getNumberOfFloors(); i++) {
            for (int j=0; j<house.getNumberOfRoomsPerFloor(); j++) {

                Room room;
                if (i+j == 0) {
                    room = new Room(residents);
                } else {
                    room = new Room();
                }

                house.addRoom(room);
            }
        }
        HouseLogger.log("New EmptyHouse was created by EmptyHouseMaker");
        return house;
    }
}