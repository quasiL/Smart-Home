package service.factory;

import model.Room;
import model.house.EmptyHouse;
import model.resident.Animal;
import model.resident.Person;
import model.resident.Resident;

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
        residents.add(new Person("John", 45));
        residents.add(new Person("Mary", 42));
        residents.add(new Person("Rachel", 18));
        residents.add(new Person("Sophia", 12));
        residents.add(new Person("Michael", 5));
        residents.add(new Person("David", 1));
        residents.add(new Animal("Bella", 3, "Dog"));
        residents.add(new Animal("Charlie", 8, "Cat"));
        residents.add(new Animal("Luna", 3, "Hamster"));
    }

    @Override
    public EmptyHouse createHouse()
    {
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
        return house;
    }
}