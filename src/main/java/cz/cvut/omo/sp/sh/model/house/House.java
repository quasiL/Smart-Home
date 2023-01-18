package cz.cvut.omo.sp.sh.model.house;

import cz.cvut.omo.sp.sh.Config;
import cz.cvut.omo.sp.sh.EventHandler;
import cz.cvut.omo.sp.sh.model.Event;
import cz.cvut.omo.sp.sh.model.EventType;
import cz.cvut.omo.sp.sh.model.Room;
import cz.cvut.omo.sp.sh.model.device.Device;
import cz.cvut.omo.sp.sh.service.observer.EventManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class House implements HouseConfiguration
{
    private final List<Room> rooms;
    private final EventHandler eventHandler;
    protected final Config config;

    protected House()
    {
        this.rooms = new ArrayList<>();
        config = new Config();
        this.eventHandler = new EventHandler();
    }

    public List<Room> getRooms()
    {
        return rooms;
    }

    public void addRoom(Room room)
    {
        rooms.add(room);
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

    public EventHandler getEventHandler()
    {
        return eventHandler;
    }
}