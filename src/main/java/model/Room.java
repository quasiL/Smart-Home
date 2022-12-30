package model;

import model.device.Device;
import model.resident.Person;
import model.resident.Resident;

import java.util.ArrayList;
import java.util.List;

public class Room
{
    private List<Resident> residents;
    private List<Device> devices;

    public Room()
    {
        this.devices = new ArrayList<>();
        this.residents = new ArrayList<>();
    }

    public Room(List<Resident> residents)
    {
        this.devices = new ArrayList<>();
        this.residents = residents;
    }

    public List<Resident> getResidents()
    {
        return residents;
    }

    public void addResident(Person person)
    {
        residents.add(person);
    }

    public void removeResident(Resident person)
    {
        residents.remove(person);
    }

    public List<Device> getDevices()
    {
        return devices;
    }

    public void addDevice(Device device)
    {
        devices.add(device);
    }

    public void removeDevice(Device device)
    {
        devices.remove(device);
    }
}