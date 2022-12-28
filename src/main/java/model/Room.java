package model;

import model.device.Device;
import model.resident.Animal;
import model.resident.Person;
import model.resident.Resident;
import java.util.ArrayList;
import java.util.List;

public class Room
{
    private List<Resident> residents;
    private List<Device> devices;

    public Room(boolean people)
    {
        devices = new ArrayList<>();
        residents = new ArrayList<>();
        if (people) {
            residents.add(new Person("John", 45));
            residents.add(new Person("Mary", 42));
            residents.add(new Person("Rachel", 18));
            residents.add(new Person("Sophia", 12));
            residents.add(new Person("Michael", 5));
            residents.add(new Person("David", 1));
            residents.add(new Animal("Bella", 3, "Dog"));
            residents.add(new Animal("Charlie", 8, "Cat"));
            residents.add(new Animal("Luna", 3, "Hamster"));
        }
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