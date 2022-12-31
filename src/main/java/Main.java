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
import service.visitor.PDFExportElectricityConsumption;

public class Main
{
    public static void main(String[] args)
    {
        HouseMaker hm = new ExtendedHouseMaker();
        House h = hm.createHouse();
        //System.out.println(h.getRooms().get(0).getDevices().get(0).isEnable());
        //h.generateEvent(EventType.FLOOD, 0);
        //System.out.println(h.getRooms().get(0).getDevices().get(0).isEnable());

        //h.getRooms().get(0).getDevices().get(0).createReports("fgdfgdfgd");
//        h.generateEvent(EventType.HOUR_HAS_PASSED);
//        h.generateEvent(EventType.HOUR_HAS_PASSED);
//        h.generateEvent(EventType.HOUR_HAS_PASSED);
//        PDFExportElectricityConsumption report = new PDFExportElectricityConsumption();
//        report.export(h.getAllDevices());

        SoundSystem soundSystem = new SoundSystem("Test",
                "manufacture",
                "0.0",
                new Battery(),
                new NetworkSettings(),
                0,
                1);

        // Turn on the sound system
        soundSystem.turnOn();
        // Add some music tracks to the sound system
        soundSystem.addMusicTrack("Track 1");
        soundSystem.addMusicTrack("Track 2");
        soundSystem.addMusicTrack("Track 3");

        // Play the first music track
        soundSystem.playTrack("Track 1");

        // Pause the music
        soundSystem.pause();

        // Resume the music
        soundSystem.resume();

        // Skip to the next music track
        soundSystem.nextTrack();

        // Turn off the sound system
        soundSystem.turnOff();
    }
}
