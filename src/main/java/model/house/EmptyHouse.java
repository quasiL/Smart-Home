package model.house;

import config.Config;

public class EmptyHouse extends House
{
    private final Config config;

    public EmptyHouse()
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