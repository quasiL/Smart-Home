package service.builder;

import model.device.Battery;
import model.device.NetworkSettings;

public class Director
{
    /**
     * Method for creating Gate Controller
     * @param builder GateControllerBuilder
     * @param room number of room
     */
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

    /**
     * Method for creating Climate Controller
     * @param builder ClimateControllerBuilder
     * @param room number of room
     */
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

    /**
     * Method for creating Light Controller
     * @param builder LightControllerBuilder
     * @param room number of room
     */
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

    /**
     * Method for creating Signaling
     * @param builder SignalingBuilder
     * @param room number of room
     */
    public void buildSignaling(DeviceBuilder builder, int room)
    {
        builder.setBattery(new Battery());
        builder.setNetworkSettings(new NetworkSettings());
        builder.setName("Signaling");
        builder.setManufacturer("HomeGenie");
        builder.setFirmwareVersion("8.1.3");
        builder.setGuarantee(6);
        builder.setRoom(room);
    }

    /**
     * Method for creating Water Controller
     * @param builder WaterControllerBuilder
     * @param room number of room
     */
    public void buildWaterController(DeviceBuilder builder, int room)
    {
        builder.setBattery(new Battery());
        builder.setNetworkSettings(new NetworkSettings());
        builder.setName("Water Controller");
        builder.setManufacturer("SmartHome Solutions");
        builder.setFirmwareVersion("2.0.1");
        builder.setGuarantee(4);
        builder.setRoom(room);
    }

    /**
     * Method for creating Sound System
     * @param builder SoundSystemBuilder
     * @param room number of room
     */
    public void buildSoundSystem(DeviceBuilder builder, int room)
    {
        builder.setBattery(new Battery());
        builder.setNetworkSettings(new NetworkSettings());
        builder.setName("Sound System");
        builder.setManufacturer("EchoHomes");
        builder.setFirmwareVersion("2.0");
        builder.setGuarantee(2);
        builder.setRoom(room);
    }

    /**
     * Method for creating Smoke Detector
     * @param builder SmokeDetectorBuilder
     * @param room number of room
     */
    public void buildSmokeDetector(DeviceBuilder builder, int room)
    {
        builder.setBattery(new Battery());
        builder.setNetworkSettings(new NetworkSettings());
        builder.setName("Smoke Detector");
        builder.setManufacturer("HomeBridge");
        builder.setFirmwareVersion("1.8");
        builder.setGuarantee(3);
        builder.setRoom(room);
    }

    /**
     * Method for creating Temperature Sensor
     * @param builder TemperatureSensorBuilder
     * @param room number of room
     */
    public void buildTemperatureSensor(DeviceBuilder builder, int room)
    {
        builder.setBattery(new Battery());
        builder.setNetworkSettings(new NetworkSettings());
        builder.setName("Temperature Sensor");
        builder.setManufacturer("HomeBridge");
        builder.setFirmwareVersion("2.2");
        builder.setGuarantee(3);
        builder.setRoom(room);
    }
}