package model.house;

import model.Event;
import model.EventType;
import model.Room;
import model.device.Device;
import service.observer.EventManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class House implements HouseConfiguration
{
    private final List<String> deviceTypes;
    private final List<Room> rooms;
    private final int numberOfFloors;
    private final int numberOfRoomsPerFloor;
    public EventManager eventManager;

    public House(List<String> deviceTypes, int numberOfFloors, int numberOfRoomsPerFloor)
    {
        this.deviceTypes = deviceTypes;
        this.rooms = new ArrayList<>();
        this.numberOfFloors = numberOfFloors;
        this.numberOfRoomsPerFloor = numberOfRoomsPerFloor;
        eventManager = new EventManager(EventType.values());
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