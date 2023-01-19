package cz.cvut.omo.sp.sh.model.device;

import cz.cvut.omo.sp.sh.service.HouseLogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DeviceReport {
    private final Device device;

    public DeviceReport(Device device) {
        this.device = device;
    }

    /**
     * Method for manual creating a base report about device
     *
     * @param fileName report's name
     */
    public void createReport(String fileName) {
        try {
            File file = new File("reports/" + fileName);
            if (file.createNewFile()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write("Name: " + device.name + " " + device.manufacturer);
                    writer.newLine();
                    writer.write("Firmware Version: " + device.firmwareVersion);
                    writer.newLine();
                    writer.write("Electricity consumption: " + device.electricityConsumption + " watts");
                    writer.newLine();
                    writer.write("Device wear: " + device.deviceWear * 100 + " %");
                    writer.newLine();
                    writer.write("Is on: " + device.isEnable());
                    writer.newLine();
                    HouseLogger.log("Report " + fileName + " was created. Check reports directory");
                }
            } else {
                HouseLogger.log("Error: can not created report " + fileName + ", file already existed.");
            }
        } catch (IOException e) {
            System.out.println("Error exporting statistics: " + e.getMessage());
        }
    }
}