package service.builder;

import model.device.Battery;
import model.device.NetworkSettings;

public class Director
{
    public void buildGateController(DeviceBuilder builder)
    {
        builder.setBattery(new Battery());
        builder.setNetworkSettings(new NetworkSettings());
        builder.setName("Gate Controller 1");
        builder.setManufacturer("Future Living Systems Inc");
        builder.setFirmwareVersion("1.0.0");
        builder.setGuarantee(3);
    }
}
