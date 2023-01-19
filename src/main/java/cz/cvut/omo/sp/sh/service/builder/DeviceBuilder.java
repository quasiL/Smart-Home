package cz.cvut.omo.sp.sh.service.builder;

import cz.cvut.omo.sp.sh.model.device.Battery;
import cz.cvut.omo.sp.sh.model.device.NetworkSettings;

public interface DeviceBuilder {
    /**
     * Battery setter
     *
     * @param battery new battery
     */
    void setBattery(Battery battery);

    /**
     * Network settings setter
     *
     * @param networkSettings new network settings
     */
    void setNetworkSettings(NetworkSettings networkSettings);

    /**
     * Name setter
     *
     * @param name new name
     */
    void setName(String name);

    /**
     * Manufacturer setter
     *
     * @param manufacturer new manufacturer
     */
    void setManufacturer(String manufacturer);

    /**
     * Firmware version setter
     *
     * @param firmwareVersion new firmware version
     */
    void setFirmwareVersion(String firmwareVersion);

    /**
     * Guarantee setter
     *
     * @param guarantee new guarantee
     */
    void setGuarantee(int guarantee);

    /**
     * Room setter
     *
     * @param room new room
     */
    void setRoom(int room);
}