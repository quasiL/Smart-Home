package model.house;

import model.Room;
import java.util.List;

public interface HouseConfiguration
{
    List<Room> getRooms();

    void addRoom(Room room);

    int getNumberOfFloors();

    int getNumberOfRoomsPerFloor();
}