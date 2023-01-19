package cz.cvut.omo.sp.sh.model.house;

public class ExtendedHouse extends House {
    @Override
    public int getNumberOfFloors() {
        return config.getFloors("extended_house");
    }

    @Override
    public int getNumberOfRoomsPerFloor() {
        return config.getRooms("extended_house");
    }
}