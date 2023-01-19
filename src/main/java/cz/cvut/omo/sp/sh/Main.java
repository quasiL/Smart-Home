package cz.cvut.omo.sp.sh;

import cz.cvut.omo.sp.sh.model.EventType;
import cz.cvut.omo.sp.sh.model.house.House;
import cz.cvut.omo.sp.sh.service.HouseLogger;
import cz.cvut.omo.sp.sh.service.factory.ExtendedHouseMaker;
import cz.cvut.omo.sp.sh.service.factory.HouseMaker;
import cz.cvut.omo.sp.sh.service.factory.SimpleHouseMaker;
import cz.cvut.omo.sp.sh.service.visitor.PDFExportElectricityConsumption;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isValid = false;
        int userChoice;
        String text = "SMART HOUSE SIMULATION\nPlease select which simulation do you want to run:\n1 - Simple house\n2 - Extended house\n\n";
        System.out.println(text);

        while (!isValid) {
            Scanner input = new Scanner(System.in);
            System.out.print("Your choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
            } else {
                userChoice = input.nextInt();
                if (userChoice == 1 || userChoice == 2) {
                    isValid = true;
                    System.out.println("Option " + userChoice + " selected. Generating simulation...");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    setSimulation(userChoice);
                } else {
                    System.out.println("Invalid selection. Please enter 1 or 2.");
                }
            }
        }
    }

    static void setSimulation(int option) {
        switch (option) {
            case 1 -> {
                HouseMaker houseMaker = new SimpleHouseMaker();
                House simpleHouse = houseMaker.createHouse();
                simpleHouse.getEventHandler().generateEvent(EventType.MORNING);
                simpleHouse.getEventHandler().generateEvent(EventType.WATER_ON);
                simpleHouse.getEventHandler().generateEvent(EventType.COLD, 0);
                simpleHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.getEventHandler().generateEvent(EventType.CHANGE_ACTION);
                simpleHouse.getEventHandler().generateEvent(EventType.ANIMAL_HUNGRY);
                simpleHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.getEventHandler().generateEvent(EventType.WATER_ON);
                simpleHouse.getEventHandler().generateEvent(EventType.SOUND_ON);
                simpleHouse.getEventHandler().generateEvent(EventType.SOUND_NEXT_TRACK);
                simpleHouse.getEventHandler().generateEvent(EventType.SOUND_PAUSE);
                simpleHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.getEventHandler().generateEvent(EventType.SOUND_RESUME);
                simpleHouse.getEventHandler().generateEvent(EventType.SOUND_OFF);
                simpleHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.getEventHandler().generateEvent(EventType.FIRE);
                simpleHouse.getEventHandler().generateEvent(EventType.EVENING);
                simpleHouse.getAllDevices().get(0).getDeviceReport().createReport("Report1");
                simpleHouse.getAllDevices().get(1).getDeviceReport().createReport("Report2");
                PDFExportElectricityConsumption report = new PDFExportElectricityConsumption();
                report.export(simpleHouse.getAllDevices());
            }
            case 2 -> {
                HouseMaker houseMaker = new ExtendedHouseMaker();
                House extendedHouse = houseMaker.createHouse();
                extendedHouse.getEventHandler().generateEvent(EventType.MORNING);
                extendedHouse.getEventHandler().generateEvent(EventType.CHANGE_ACTION);
                extendedHouse.getEventHandler().generateEvent(EventType.WARM, 1);
                extendedHouse.getEventHandler().generateEvent(EventType.WATER_ON);
                extendedHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.getEventHandler().generateEvent(EventType.WARM, 1);
                extendedHouse.getEventHandler().generateEvent(EventType.ANIMAL_HUNGRY);
                extendedHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.getEventHandler().generateEvent(EventType.WATER_ON);
                extendedHouse.getEventHandler().generateEvent(EventType.SOUND_ON);
                extendedHouse.getEventHandler().generateEvent(EventType.SOUND_NEXT_TRACK);
                extendedHouse.getEventHandler().generateEvent(EventType.SOUND_PAUSE);
                extendedHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.getEventHandler().generateEvent(EventType.SOUND_RESUME);
                extendedHouse.getEventHandler().generateEvent(EventType.SOUND_OFF);
                extendedHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.getEventHandler().generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.getEventHandler().generateEvent(EventType.WATER_ON);
                extendedHouse.getEventHandler().generateEvent(EventType.FLOOD);
                extendedHouse.getAllDevices().get(0).getDeviceReport().createReport("Report3");
                extendedHouse.getAllDevices().get(1).getDeviceReport().createReport("Report4");
                //extendedHouse.getAllDevices().get(0).createReports("Report2");
                //extendedHouse.getAllDevices().get(1).createReports("Report3");
                PDFExportElectricityConsumption report = new PDFExportElectricityConsumption();
                report.export(extendedHouse.getAllDevices());
            }
            default -> HouseLogger.log("Program ended with an error");
        }
    }
}