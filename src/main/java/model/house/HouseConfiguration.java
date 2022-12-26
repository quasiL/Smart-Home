package model.house;

import model.Room;
import java.util.List;

public interface HouseConfiguration
{
    List<String> getDeviceTypes();

    List<Room> getRooms();

    void addRoom(Room room);

    int getNumberOfFloors();

    int getNumberOfRoomsPerFloor();
}