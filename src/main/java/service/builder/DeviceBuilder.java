package service.builder;

import model.device.Battery;
import model.device.NetworkSettings;

public interface DeviceBuilder
{
    void setBattery(Battery battery);

    void setNetworkSettings(NetworkSettings networkSettings);

    void setName(String name);

    void setManufacturer(String manufacturer);

    void setFirmwareVersion(String firmwareVersion);

    void setGuarantee(int guarantee);

    void setRoom(int room);
}