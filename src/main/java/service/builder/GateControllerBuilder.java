package service.builder;

import model.device.Battery;
import model.device.DeviceType;
import model.device.GateController;
import model.device.NetworkSettings;

public class GateControllerBuilder implements DeviceBuilder
{
    private String name;
    private String manufacturer;
    private String firmwareVersion;
    private DeviceType type;
    private Battery battery;
    private NetworkSettings networkSettings;
    private int guarantee;

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

    public GateController getResult()
    {
        return new GateController(name, manufacturer, firmwareVersion, battery, networkSettings, guarantee);
    }
}
