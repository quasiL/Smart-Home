package cz.cvut.omo.sp.smart_home.model.house;

import cz.cvut.omo.sp.smart_home.config.Config;

public class SimpleHouse extends House
{
    private final Config config;

    public SimpleHouse()
    {
        config = new Config("simple_house");
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