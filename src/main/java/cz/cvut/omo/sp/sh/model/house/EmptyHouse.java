package cz.cvut.omo.sp.sh.model.house;

public class EmptyHouse extends House
{
    @Override
    public int getNumberOfFloors()
    {
        return config.getFloors("empty_house");
    }

    @Override
    public int getNumberOfRoomsPerFloor()
    {
        return config.getRooms("empty_house");
    }
}