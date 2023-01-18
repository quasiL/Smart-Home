import cz.cvut.omo.sp.sh.model.device.Battery;
import cz.cvut.omo.sp.sh.model.device.NetworkSettings;
import cz.cvut.omo.sp.sh.model.device.SoundSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class StateTest
{
    private SoundSystem soundSystem;
    private String track1;
    private String track2;

    @BeforeEach
    void createSoundSystemForTestsManually()
    {
        soundSystem = new SoundSystem(
                "Test Sound System",
                "manufacture",
                "0.0",
                new Battery(),
                new NetworkSettings(),
                0,
                1);
        track1 = "Track 1";
        track2 = "Track 2";
    }

    @Test
    @Order(0)
    void checkIfTrackSelectingWorks_isSelect_returnsNextTrack()
    {
        soundSystem.turnOn();
        soundSystem.addMusicTrack(track1);
        soundSystem.addMusicTrack(track2);
        soundSystem.playTrack(track1);
        soundSystem.nextTrack();
        Assertions.assertEquals(soundSystem.getCurrentTrack(), track2);
    }
}
