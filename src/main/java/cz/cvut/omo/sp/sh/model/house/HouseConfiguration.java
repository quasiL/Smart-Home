package cz.cvut.omo.sp.sh.model.house;

import cz.cvut.omo.sp.sh.model.Room;

import java.util.List;

public interface HouseConfiguration {
    List<Room> getRooms();

    void addRoom(Room room);

    int getNumberOfFloors();

    int getNumberOfRoomsPerFloor();
}