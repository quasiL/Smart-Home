package model.device;

import model.Event;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Device
{
    private final LocalDate guarantee;
    private final int id;
    private final String ipAddress;
    private final String macAddress;
    private final String model;
    private boolean status;
    private final LocalDateTime timeFromStart;

    public Device(int guarantee, int id, String ipAddress, String macAddress, String model)
    {
        this.guarantee = LocalDate.now().plusYears(guarantee);
        this.id = id;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.model = model;
        this.status = false;
        this.timeFromStart = LocalDateTime.from(LocalDateTime.now());
    }

    public LocalDate getGuarantee()
    {
        return guarantee;
    }

    public int getId()
    {
        return id;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public String getMacAddress()
    {
        return macAddress;
    }

    public String getModel()
    {
        return model;
    }

    public boolean getStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
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