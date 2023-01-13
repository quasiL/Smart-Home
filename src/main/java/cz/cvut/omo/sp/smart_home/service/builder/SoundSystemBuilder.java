package cz.cvut.omo.sp.smart_home.service.builder;

import cz.cvut.omo.sp.smart_home.model.device.Battery;
import cz.cvut.omo.sp.smart_home.model.device.NetworkSettings;
import cz.cvut.omo.sp.smart_home.model.device.SoundSystem;
import cz.cvut.omo.sp.smart_home.service.HouseLogger;

public class SoundSystemBuilder implements DeviceBuilder
{
    private String name;
    private String manufacturer;
    private String firmwareVersion;
    private Battery battery;
    private NetworkSettings networkSettings;
    private int guarantee;
    private int room;

    @Override
    public void setBattery(Battery battery)
    {
        this.battery = battery;
    }

    @Override
    public void setNetworkSettings(NetworkSettings networkSettings)
    {
        this.networkSettings = networkSettings;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    @Override
    public void setFirmwareVersion(String firmwareVersion)
    {
        this.firmwareVersion = firmwareVersion;
    }

    @Override
    public void setGuarantee(int guarantee)
    {
        this.guarantee = guarantee;
    }

    @Override
    public void setRoom(int room)
    {
        this.room = room;
    }

    /**
     * Method for creating new instance of SoundSystem
     * @return new SoundSystem
     */
    public SoundSystem getResult()
    {
        HouseLogger.log("New " + name + " was created by SoundSystemBuilder");
        return new SoundSystem(name, manufacturer, firmwareVersion, battery, networkSettings, guarantee, room);
    }
}