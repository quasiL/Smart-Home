import model.EventType;
import model.house.House;
import service.factory.ExtendedHouseMaker;
import service.factory.HouseMaker;
import service.factory.SimpleHouseMaker;
import service.visitor.PDFExportElectricityConsumption;

public class Main
{
    public static void main(String[] args)
    {
        int option = 2;
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