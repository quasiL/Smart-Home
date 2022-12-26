package service.factory;

import model.Room;
import model.house.EmptyHouse;

public class EmptyHouseMaker extends HouseMaker
{
    private final EmptyHouse house;

    public EmptyHouseMaker()
    {
        this.house = new EmptyHouse();
    }

    @Override
    public EmptyHouse createHouse()
    {
        for (int i=0; i<house.getNumberOfFloors(); i++) {
            for (int j=0; j<house.getNumberOfRoomsPerFloor(); j++) {
                house.addRoom(new Room());
            }
        }
        return house;
    }
}
