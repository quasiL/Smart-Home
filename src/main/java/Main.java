import config.Config;
import model.EventType;
import model.device.Battery;
import model.device.NetworkSettings;
import model.device.SoundSystem;
import model.house.EmptyHouse;
import model.house.House;
import service.builder.Director;
import service.factory.EmptyHouseMaker;
import service.factory.ExtendedHouseMaker;
import service.factory.HouseMaker;
import service.factory.SimpleHouseMaker;
import service.visitor.PDFExportElectricityConsumption;

public class Main
{
    public static void main(String[] args)
    {
        HouseMaker hm = new ExtendedHouseMaker();
        House h = hm.createHouse();
        System.out.println(h.getRooms().get(0).getDevices().get(0).isEnable());
//        //h.generateEvent(EventType.FLOOD, 0);
//        //System.out.println(h.getRooms().get(0).getDevices().get(0).isEnable());
//
//
//        h.generateEvent(EventType.HOUR_HAS_PASSED);
//        h.generateEvent(EventType.HOUR_HAS_PASSED);
//        h.generateEvent(EventType.HOUR_HAS_PASSED);
//        PDFExportElectricityConsumption report = new PDFExportElectricityConsumption();
//        report.export(h.getAllDevices());
        SoundSystem soundSystem = new SoundSystem("Test Sound System",
                "manufacture",
                "0.0",
                new Battery(),
                new NetworkSettings(),
                0,
                1);
        soundSystem.turnOn();
        soundSystem.playTrack(soundSystem.getMusicTracks().get(0));
        soundSystem.nextTrack();
        soundSystem.turnOff();
        //h.getRooms().get(0).getDevices().get(0).createReports("444");
    }
}