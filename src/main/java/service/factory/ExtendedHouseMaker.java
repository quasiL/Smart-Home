package service.factory;

import model.Room;
import model.house.ExtendedHouse;

public class ExtendedHouseMaker extends HouseMaker
{
    private final ExtendedHouse house;

    public ExtendedHouseMaker()
    {
        this.house = new ExtendedHouse();
    }

    @Override
    public ExtendedHouse createHouse()
    {
        for (int i=0; i<house.getNumberOfFloors(); i++) {
            for (int j=0; j<house.getNumberOfRoomsPerFloor(); j++) {
                house.addRoom(new Room());
            }
        }
        return house;
    }
}
