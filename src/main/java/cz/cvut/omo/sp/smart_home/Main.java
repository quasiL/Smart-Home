package cz.cvut.omo.sp.smart_home;

import cz.cvut.omo.sp.smart_home.model.EventType;
import cz.cvut.omo.sp.smart_home.model.house.House;
import cz.cvut.omo.sp.smart_home.service.factory.ExtendedHouseMaker;
import cz.cvut.omo.sp.smart_home.service.factory.HouseMaker;
import cz.cvut.omo.sp.smart_home.service.factory.SimpleHouseMaker;
import cz.cvut.omo.sp.smart_home.service.visitor.PDFExportElectricityConsumption;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Boolean isValid = false;
        int userChoice;

        System.out.println(
                "SMART HOUSE SIMULATION\n" +
                "Please select which simulation do you want to run:\n" +
                        "1 - Simple house\n" +
                        "2 - Extended house\n\n");

        while (true) {
            if (isValid)
                break;

            Scanner input = new Scanner(System.in);
            System.out.print("Your choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
            }

            else {
                userChoice = input.nextInt();
                if ( userChoice == 1 || userChoice == 2) {
                    isValid = true;
                    System.out.println("Option " + userChoice + " selected. Generating simulation...");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    setSimulation(userChoice);
                }
                else
                    System.out.println("Invalid selection. Please enter 1 or 2.");
            }
        }
    }

    static void setSimulation(int option) {
        switch (option) {
            case 1 -> {
                HouseMaker houseMaker = new SimpleHouseMaker();
                House simpleHouse = houseMaker.createHouse();
                simpleHouse.generateEvent(EventType.MORNING);
                simpleHouse.generateEvent(EventType.WATER_ON);
                simpleHouse.generateEvent(EventType.COLD, 0);
                simpleHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.generateEvent(EventType.CHANGE_ACTION);
                simpleHouse.generateEvent(EventType.ANIMAL_HUNGRY);
                simpleHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.generateEvent(EventType.WATER_ON);
                simpleHouse.generateEvent(EventType.SOUND_ON);
                simpleHouse.generateEvent(EventType.SOUND_NEXT_TRACK);
                simpleHouse.generateEvent(EventType.SOUND_PAUSE);
                simpleHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.generateEvent(EventType.SOUND_RESUME);
                simpleHouse.generateEvent(EventType.SOUND_OFF);
                simpleHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                simpleHouse.generateEvent(EventType.FIRE);
                simpleHouse.generateEvent(EventType.EVENING);
                simpleHouse.getAllDevices().get(0).createReports("Report1");
                simpleHouse.getAllDevices().get(1).createReports("Report2");
                PDFExportElectricityConsumption report = new PDFExportElectricityConsumption();
                report.export(simpleHouse.getAllDevices());
            }
            case 2 -> {
                HouseMaker houseMaker = new ExtendedHouseMaker();
                House extendedHouse = houseMaker.createHouse();
                extendedHouse.generateEvent(EventType.MORNING);
                extendedHouse.generateEvent(EventType.CHANGE_ACTION);
                extendedHouse.generateEvent(EventType.WARM, 1);
                extendedHouse.generateEvent(EventType.WATER_ON);
                extendedHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.generateEvent(EventType.WARM, 1);
                extendedHouse.generateEvent(EventType.ANIMAL_HUNGRY);
                extendedHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.generateEvent(EventType.WATER_ON);
                extendedHouse.generateEvent(EventType.SOUND_ON);
                extendedHouse.generateEvent(EventType.SOUND_NEXT_TRACK);
                extendedHouse.generateEvent(EventType.SOUND_PAUSE);
                extendedHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.generateEvent(EventType.SOUND_RESUME);
                extendedHouse.generateEvent(EventType.SOUND_OFF);
                extendedHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.generateEvent(EventType.HOUR_HAS_PASSED);
                extendedHouse.generateEvent(EventType.WATER_ON);
                extendedHouse.generateEvent(EventType.FLOOD);
                extendedHouse.getAllDevices().get(0).createReports("Report2");
                extendedHouse.getAllDevices().get(1).createReports("Report3");
                PDFExportElectricityConsumption report = new PDFExportElectricityConsumption();
                report.export(extendedHouse.getAllDevices());
            }
            default -> System.out.println("Error");
        }
    }
}