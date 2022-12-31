package model.house;

import config.Config;
import model.Event;
import model.EventType;
import model.Room;
import model.device.Device;
import service.observer.EventManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class House implements HouseConfiguration
{
    private final List<Room> rooms;
    public EventManager eventManager;
    private final Config config;

    public House()
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
                .collect(Collectors.toList());
        return newList;
    }
}