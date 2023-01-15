package cz.cvut.omo.sp.smart_home.model.house;

import cz.cvut.omo.sp.smart_home.config.Config;
import cz.cvut.omo.sp.smart_home.model.Event;
import cz.cvut.omo.sp.smart_home.model.EventType;
import cz.cvut.omo.sp.smart_home.model.Room;
import cz.cvut.omo.sp.smart_home.model.device.Device;
import cz.cvut.omo.sp.smart_home.service.observer.EventManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class House implements HouseConfiguration
{
    private final List<Room> rooms;
    public EventManager eventManager;
    private final Config config;

    protected House()
    {
        this.rooms = new ArrayList<>();
        config = new Config("default");
        eventManager = new EventManager(EventType.values());
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
        return config.getFloors();
    }

    public int getNumberOfRoomsPerFloor()
    {
        return config.getRooms();
    }

    public void generateEvent(EventType type, int room)
    {
        Event event = new Event(type, room);
        eventManager.notify(event);
    }

    public void generateEvent(EventType type)
    {
        Event event = new Event(type);
        eventManager.notify(event);
    }

    public List<Device> getAllDevices()
    {
        List<Device> newList;
        newList = getRooms().stream()
                .map(Room::getDevices)
                .flatMap(Collection::stream)
                .toList();
        return newList;
    }
}