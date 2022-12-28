package service.factory;

import model.Room;
import model.house.SimpleHouse;

public class SimpleHouseMaker extends HouseMaker
{
    private final SimpleHouse house;

    public SimpleHouseMaker()
    {
        this.house = new SimpleHouse();
    }

    @Override
    public SimpleHouse createHouse()
    {
        boolean people = true;
        for (int i=0; i<house.getNumberOfFloors(); i++) {
            for (int j=0; j<house.getNumberOfRoomsPerFloor(); j++) {
                house.addRoom(new Room(people));
                people = false;
            }
        }
        return house;
    }
}
