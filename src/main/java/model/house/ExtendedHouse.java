package model.house;

import config.Config;

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