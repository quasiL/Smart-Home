package cz.cvut.omo.sp.sh.model.house;

public class SimpleHouse extends House
{
    @Override
    public int getNumberOfFloors()
    {
        return config.getFloors("simple_house");
    }

    @Override
    public int getNumberOfRoomsPerFloor()
    {
        return config.getRooms("simple_house");
    }
}