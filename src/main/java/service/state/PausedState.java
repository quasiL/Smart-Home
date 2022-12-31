package service.state;

import model.device.SoundSystem;
import service.HouseLogger;

public class PausedState extends State
{
    public PausedState(SoundSystem soundSystem)
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
        soundSystem.setState(new OffState(soundSystem));
    }

    @Override
    public void playTrack(String track)
    {
        if (soundSystem.getMusicTracks().contains(track)) {
            HouseLogger.log("Playing track: " + track);
            soundSystem.setCurrentTrack(track);
            soundSystem.setState(new PlayingState(soundSystem));
        } else {
            HouseLogger.log("Track not found: " + track);
        }
    }

    @Override
    public void nextTrack()
    {
        int currentIndex = soundSystem.getMusicTracks().indexOf(soundSystem.getCurrentTrack());
        if (currentIndex < soundSystem.getMusicTracks().size() - 1) {
            String nextTrack = soundSystem.getMusicTracks().get(currentIndex + 1);
            HouseLogger.log("Playing track: " + nextTrack);
            soundSystem.setCurrentTrack(nextTrack);
            soundSystem.setState(new PlayingState(soundSystem));
        } else {
            HouseLogger.log("No more tracks to play");
        }
    }

    @Override
    public void previousTrack()
    {
        int currentIndex = soundSystem.getMusicTracks().indexOf(soundSystem.getCurrentTrack());
        if (currentIndex > 0) {
            String previousTrack = soundSystem.getMusicTracks().get(currentIndex - 1);
            HouseLogger.log("Playing track: " + previousTrack);
            soundSystem.setCurrentTrack(previousTrack);
            soundSystem.setState(new PlayingState(soundSystem));
        } else {
            HouseLogger.log("No more tracks to play");
        }
    }

    @Override
    public void pause()
    {
        // Do nothing, since the music is already paused
    }

    @Override
    public void resume()
    {
        HouseLogger.log("Resuming music...");
        soundSystem.setState(new PlayingState(soundSystem));
    }
}