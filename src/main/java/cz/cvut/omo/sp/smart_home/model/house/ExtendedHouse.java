package cz.cvut.omo.sp.smart_home.model.house;

import cz.cvut.omo.sp.smart_home.config.Config;

public class ExtendedHouse extends House
{
    private final Config config;

    public ExtendedHouse()
    {
        config = new Config("extended_house");
    }

    @Override
    public int getNumberOfFloors()
    {
        return config.getFloors();
    }

    @Override
    public int getNumberOfRoomsPerFloor()
    {
        return config.getRooms();
    }
}