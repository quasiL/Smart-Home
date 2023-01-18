package cz.cvut.omo.sp.sh.service.state;

import cz.cvut.omo.sp.sh.model.device.SoundSystem;
import cz.cvut.omo.sp.sh.service.HouseLogger;

public class PlayingState extends State
{
    public PlayingState(SoundSystem soundSystem)
    {
        super(soundSystem);
    }

    @Override
    public void turnOn()
    {
        // Do nothing, since the sound system is already on
    }

    @Override
    public void turnOff()
    {
        HouseLogger.log("Turning off the sound system...");
        getSoundSystem().setState(new OffState(getSoundSystem()));
    }

    @Override
    public void playTrack(String track)
    {
        if (getSoundSystem().getMusicTracks().contains(track)) {
            HouseLogger.log("Playing track: " + track);
            getSoundSystem().setCurrentTrack(track);
        } else {
            HouseLogger.log("Track not found: " + track);
        }
    }

    @Override
    public void nextTrack()
    {
        int currentIndex = getSoundSystem().getMusicTracks().indexOf(getSoundSystem().getCurrentTrack());
        if (currentIndex < getSoundSystem().getMusicTracks().size() - 1) {
            String nextTrack = getSoundSystem().getMusicTracks().get(currentIndex + 1);
            HouseLogger.log("Playing track: " + nextTrack);
            getSoundSystem().setCurrentTrack(nextTrack);
        } else {
            HouseLogger.log("No more tracks to play");
        }
    }

    @Override
    public void previousTrack()
    {
        int currentIndex = getSoundSystem().getMusicTracks().indexOf(getSoundSystem().getCurrentTrack());
        if (currentIndex > 0) {
            String previousTrack = getSoundSystem().getMusicTracks().get(currentIndex - 1);
            HouseLogger.log("Playing track: " + previousTrack);
            getSoundSystem().setCurrentTrack(previousTrack);
        } else {
            HouseLogger.log("No more tracks to play");
        }
    }

    @Override
    public void pause()
    {
        HouseLogger.log("Pausing music...");
        getSoundSystem().setState(new PausedState(getSoundSystem()));
    }

    @Override
    public void resume()
    {
        // Do nothing, since the music is already playing
    }
}