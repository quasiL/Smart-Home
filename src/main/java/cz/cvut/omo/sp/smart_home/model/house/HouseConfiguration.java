package cz.cvut.omo.sp.smart_home.model.house;

import cz.cvut.omo.sp.smart_home.model.Room;
import java.util.List;

public interface HouseConfiguration
{
    List<Room> getRooms();

    void addRoom(Room room);

    int getNumberOfFloors();

    int getNumberOfRoomsPerFloor();
}