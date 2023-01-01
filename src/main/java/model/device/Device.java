package model.device;

import service.HouseLogger;
import service.visitor.Visitor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Device implements BasicActions
{
    protected final String name;
    protected final String manufacturer;
    protected final String firmwareVersion;
    private final DeviceType type;
    private boolean enable;
    private final Battery battery;
    private NetworkSettings networkSettings;
    private final LocalDate guarantee;
    private final LocalDateTime timeFromStart;
    protected final int room;
    protected int electricityConsumption;
    protected double deviceWear;

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
        this.electricityConsumption = 0;
        this.deviceWear = 0.0;
    }

    public void createReports(String fileName)
    {
        try {
            File file = new File("reports/" + fileName);
            file.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("Name: " + name + " " + manufacturer);
            writer.newLine();
            writer.write("Firmware Version: " + firmwareVersion);
            writer.newLine();
            writer.write("Electricity consumption: " + electricityConsumption + " watts");
            writer.newLine();
            writer.write("Device wear: " + deviceWear * 100 + " %");
            writer.newLine();
            writer.write("Is on: " + isEnable());
            writer.newLine();
            writer.close();
            HouseLogger.log("Report " + fileName + " was created. Check reports directory");
        } catch (IOException e) {
            System.out.println("Error exporting statistics: " + e.getMessage());
        }
    }

    public String[] accept(Visitor visitor)
    {
        return null;
    }

    public void restart()
    {
        HouseLogger.log("Device " + name + " was manually restarted");
        enable = true;
    }

    public void synchronizeTime()
    {
        HouseLogger.log("Device " + name + " has synchronize it's time");
    }

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

    public int getRoom()
    {
        return room;
    }

    public int getElectricityConsumption()
    {
        return electricityConsumption;
    }

    public void increaseElectricityConsumption(int electricityConsumption)
    {
        this.electricityConsumption += electricityConsumption;
    }

    public double getDeviceWear()
    {
        return deviceWear;
    }

    public void increaseDeviceWear(double deviceWear)
    {
        this.deviceWear += deviceWear;
    }
}