package cz.cvut.omo.sp.sh.service.state;

import cz.cvut.omo.sp.sh.model.device.SoundSystem;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class OffState extends State {
    public OffState(SoundSystem soundSystem) {
        super(soundSystem);
    }

    @Override
    public void turnOn() {
        HouseLogger.log("Turning on the sound system...");
        getSoundSystem().setState(new OnState(getSoundSystem()));
    }

    @Override
    public void turnOff() {
        // Do nothing, since the sound system is already off
    }

    @Override
    public void playTrack(String track) {
        HouseLogger.log("Cannot play a track when the sound system is off");
    }

    @Override
    public void nextTrack() {
        HouseLogger.log("Cannot skip to the next track when the sound system is off");
    }

    @Override
    public void previousTrack() {
        HouseLogger.log("Cannot skip to the previous track when the sound system is off");
    }

    @Override
    public void pause() {
        HouseLogger.log("Cannot pause the music when the sound system is off");
    }

    @Override
    public void resume() {
        HouseLogger.log("Cannot resume the music when the sound system is off");
    }
}