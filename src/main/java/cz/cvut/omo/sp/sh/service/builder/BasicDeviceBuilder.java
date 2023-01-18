package cz.cvut.omo.sp.sh.service.builder;

import cz.cvut.omo.sp.sh.model.device.Battery;
import cz.cvut.omo.sp.sh.model.device.NetworkSettings;

public abstract class BasicDeviceBuilder implements DeviceBuilder
{
    protected String name;
    protected String manufacturer;
    protected String firmwareVersion;
    protected Battery battery;
    protected NetworkSettings networkSettings;
    protected int guarantee;
    protected int room;

    public void setBattery(Battery battery)
    {
        this.battery = battery;
    }

    public void setNetworkSettings(NetworkSettings networkSettings)
    {
        this.networkSettings = networkSettings;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public void setFirmwareVersion(String firmwareVersion)
    {
        this.firmwareVersion = firmwareVersion;
    }

    public void setGuarantee(int guarantee)
    {
        this.guarantee = guarantee;
    }

    public void setRoom(int room)
    {
        this.room = room;
    }
}