package cz.cvut.omo.sp.sh.service.state;

import cz.cvut.omo.sp.sh.model.device.SoundSystem;

public abstract class State
{
    /**
     * Music playback system
     */
    private final SoundSystem soundSystem;

    protected State(SoundSystem soundSystem)
    {
        this.soundSystem = soundSystem;
    }

    /**
     * Method for turning the sound system on
     */
    public abstract void turnOn();

    /**
     * Method for turning the sound system off
     */
    public abstract void turnOff();

    /**
     * Method for playing a music track
     * @param track track
     */
    public abstract void playTrack(String track);

    /**
     * Method for skipping to the next music track
     */
    public abstract void nextTrack();

    /**
     * Method for skipping to the previous music track
     */
    public abstract void previousTrack();

    /**
     * Method for pausing the music
     */
    public abstract void pause();

    /**
     * Method for resuming the music
     */
    public abstract void resume();

    public SoundSystem getSoundSystem()
    {
        return soundSystem;
    }
}