package service.state;

import model.device.SoundSystem;
import service.HouseLogger;

public class OnState extends State
{
    public OnState(SoundSystem soundSystem)
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
        HouseLogger.log("Cannot skip to the next track when no track is playing");
    }

    @Override
    public void previousTrack()
    {
        HouseLogger.log("Cannot skip to the previous track when no track is playing");
    }

    @Override
    public void pause()
    {
        HouseLogger.log("Cannot pause the music when no track is playing");
    }

    @Override
    public void resume()
    {
        HouseLogger.log("Cannot resume the music when no track is playing");
    }
}