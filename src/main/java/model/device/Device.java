package model.device;

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
    protected final int room;
    private int electricityConsuming;
    private double deviceWear;

    public Device(String name,
                  String manufacturer,
                  String firmwareVersion,
                  DeviceType type,
                  Battery battery,
                  NetworkSettings networkSettings,
                  int guarantee,
                  int room)
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
        this.room = room;
        this.electricityConsuming = 0;
        this.deviceWear = 0.1;
    }

    public void countElectricity() {}
    public void createReports() {}
    public void restart()
    {
        //add something to the log
        enable = true;
    }
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

    public boolean isEnable()
    {
        return enable;
    }

    public void setEnable(boolean status)
    {
        this.enable = status;
    }

    public LocalDateTime getTimeFromStart()
    {
        return LocalDateTime.from(timeFromStart);
    }

    public LocalDateTime calculateRemainingTime()
    {
        return LocalDateTime.now();
    }

    public int getElectricityConsuming()
    {
        return electricityConsuming;
    }

    public void increaseElectricityConsuming(int electricityConsuming)
    {
        this.electricityConsuming += electricityConsuming;
    }

    public double getDeviceWear()
    {
        return deviceWear;
    }

    public void increaseDeviceWear(double deviceWear)
    {
        this.deviceWear -= deviceWear;
    }
}