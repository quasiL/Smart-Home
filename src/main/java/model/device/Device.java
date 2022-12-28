package model.device;

import model.Event;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Device implements BasicActions
{
    private final String name;
    private final String manufacturer;
    private final String firmwareVersion;
    private final DeviceType type;
    private boolean enable;
    private final Battery battery;
    private NetworkSettings networkSettings;
    private final LocalDate guarantee;
    private final LocalDateTime timeFromStart;

    public Device(String name,
                  String manufacturer,
                  String firmwareVersion,
                  DeviceType type,
                  Battery battery,
                  NetworkSettings networkSettings,
                  int guarantee)
    {
        this.name = name;
        this.manufacturer = manufacturer;
        this.firmwareVersion = firmwareVersion;
        this.type = type;
        this.battery = battery;
        this.networkSettings = networkSettings;
        this.guarantee = LocalDate.now().plusYears(guarantee);
        this.timeFromStart = LocalDateTime.from(LocalDateTime.now());
        this.enable = true;
    }

    public void countElectricity() {}
    public void createReports() {}
    public void restart() {}
    public void synchronizeTime() {}

    public LocalDate getGuarantee()
    {
        return guarantee;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public DeviceType getType() {
        return type;
    }

    public Battery getBattery() {
        return battery;
    }

    public NetworkSettings getNetworkSettings() {
        return networkSettings;
    }

    public void setNetworkSettings(NetworkSettings networkSettings)
    {
        this.networkSettings = networkSettings;
    }

    public boolean getStatus()
    {
        return enable;
    }

    public void setStatus(boolean status)
    {
        this.enable = status;
    }

    public LocalDateTime getTimeFromStart()
    {
        return LocalDateTime.from(timeFromStart);
    }

    public Event createEvent()
    {
        return new Event();
    }

    public LocalDateTime calculateRemainingTime()
    {
        return LocalDateTime.now();
    }
}