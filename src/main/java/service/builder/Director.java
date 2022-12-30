package service.builder;

import model.device.Battery;
import model.device.NetworkSettings;

public class Director
{
    public void buildGateController(DeviceBuilder builder, int room)
    {
        builder.setBattery(new Battery());
        builder.setNetworkSettings(new NetworkSettings());
        builder.setName("Gate Controller");
        builder.setManufacturer("Future Living Systems Inc");
        builder.setFirmwareVersion("1.2.0");
        builder.setGuarantee(3);
        builder.setRoom(room);
    }

    public void buildClimateController(DeviceBuilder builder, int room)
    {
        builder.setBattery(new Battery());
        builder.setNetworkSettings(new NetworkSettings());
        builder.setName("Climate Controller");
        builder.setManufacturer("Home Connect Co");
        builder.setFirmwareVersion("3.1");
        builder.setGuarantee(2);
        builder.setRoom(room);
    }

    public void buildLightController(DeviceBuilder builder, int room)
    {
        builder.setBattery(new Battery());
        builder.setNetworkSettings(new NetworkSettings());
        builder.setName("Light Controller");
        builder.setManufacturer("Connected Living Inc");
        builder.setFirmwareVersion("1.12");
        builder.setGuarantee(2);
        builder.setRoom(room);
    }
}
