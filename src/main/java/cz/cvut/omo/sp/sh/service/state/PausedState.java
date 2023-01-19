package cz.cvut.omo.sp.sh.service.state;

import cz.cvut.omo.sp.sh.model.device.SoundSystem;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class PausedState extends State {
    public PausedState(SoundSystem soundSystem) {
        super(soundSystem);
    }

    @Override
    public void turnOn() {
        // Do nothing, since the sound system is already on
    }

    @Override
    public void turnOff() {
        HouseLogger.log("Turning off the sound system...");
        getSoundSystem().setState(new OffState(getSoundSystem()));
    }

    @Override
    public void playTrack(String track) {
        if (getSoundSystem().getMusicTracks().contains(track)) {
            HouseLogger.log("Playing track: " + track);
            getSoundSystem().setCurrentTrack(track);
            getSoundSystem().setState(new PlayingState(getSoundSystem()));
        } else {
            HouseLogger.log("Track not found: " + track);
        }
    }

    @Override
    public void nextTrack() {
        int currentIndex = getSoundSystem().getMusicTracks().indexOf(getSoundSystem().getCurrentTrack());
        if (currentIndex < getSoundSystem().getMusicTracks().size() - 1) {
            String nextTrack = getSoundSystem().getMusicTracks().get(currentIndex + 1);
            HouseLogger.log("Playing track: " + nextTrack);
            getSoundSystem().setCurrentTrack(nextTrack);
            getSoundSystem().setState(new PlayingState(getSoundSystem()));
        } else {
            HouseLogger.log("No more tracks to play");
        }
    }

    @Override
    public void previousTrack() {
        int currentIndex = getSoundSystem().getMusicTracks().indexOf(getSoundSystem().getCurrentTrack());
        if (currentIndex > 0) {
            String previousTrack = getSoundSystem().getMusicTracks().get(currentIndex - 1);
            HouseLogger.log("Playing track: " + previousTrack);
            getSoundSystem().setCurrentTrack(previousTrack);
            getSoundSystem().setState(new PlayingState(getSoundSystem()));
        } else {
            HouseLogger.log("No more tracks to play");
        }
    }

    @Override
    public void pause() {
        // Do nothing, since the music is already paused
    }

    @Override
    public void resume() {
        HouseLogger.log("Resuming music...");
        getSoundSystem().setState(new PlayingState(getSoundSystem()));
    }
}