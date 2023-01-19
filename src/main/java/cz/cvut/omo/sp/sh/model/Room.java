package cz.cvut.omo.sp.sh.model;

import cz.cvut.omo.sp.sh.model.device.Device;
import cz.cvut.omo.sp.sh.model.resident.Person;
import cz.cvut.omo.sp.sh.model.resident.Resident;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<Resident> residents;
    private final List<Device> devices;

    public Room() {
        this.devices = new ArrayList<>();
        this.residents = new ArrayList<>();
    }

    public Room(List<Resident> residents) {
        this.devices = new ArrayList<>();
        this.residents = residents;
    }

    public List<Resident> getResidents() {
        return new ArrayList<>(residents);
    }

    public void addResident(Person person) {
        residents.add(person);
    }

    public void removeResident(Resident person) {
        residents.remove(person);
    }

    public List<Device> getDevices() {
        return new ArrayList<>(devices);
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }
}