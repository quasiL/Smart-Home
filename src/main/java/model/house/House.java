package model.house;

import model.Room;
import java.util.ArrayList;
import java.util.List;

public abstract class House implements HouseConfiguration
{
    private final List<String> deviceTypes;
    private final List<Room> rooms;
    private final int numberOfFloors;
    private final int numberOfRoomsPerFloor;

    public House(List<String> deviceTypes, int numberOfFloors, int numberOfRoomsPerFloor)
    {
        this.deviceTypes = deviceTypes;
        this.rooms = new ArrayList<>();
        this.numberOfFloors = numberOfFloors;
        this.numberOfRoomsPerFloor = numberOfRoomsPerFloor;
    }

    public List<String> getDeviceTypes()
    {
        return deviceTypes;
    }

    public List<Room> getRooms()
    {
        return rooms;
    }

    public void addRoom(Room room)
    {
        rooms.add(room);
    }

    public int getNumberOfFloors()
    {
        return numberOfFloors;
    }

    public int getNumberOfRoomsPerFloor()
    {
        return numberOfRoomsPerFloor;
    }
}