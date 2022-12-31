package model.device;

import model.Event;
import service.observer.EventListener;
import service.state.OffState;
import service.state.State;
import service.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class SoundSystem extends Device implements EventListener
{
    /**
     * The current state of the sound system
     */
    private State state;

    /**
     * The list of available music tracks
     */
    private List<String> musicTracks;

    /**
     * The current music track being played
     */
    private String currentTrack;

    public SoundSystem(String name,
                       String manufacturer,
                       String firmwareVersion,
                       Battery battery,
                       NetworkSettings networkSettings,
                       int guarantee,
                       int room)
    {
        super(name, manufacturer, firmwareVersion, DeviceType.SOUND_SYSTEM, battery, networkSettings, guarantee, room);
        this.state = new OffState(this);
        this.musicTracks = new ArrayList<>(List.of("Track 1", "Track 2", "Track 3"));
    }

    @Override
    public void update(Event event)
    {
        switch (event.getEventType()) {
            case HOUR_HAS_PASSED -> {
                if (isEnable()) {
                    increaseDeviceWear(0.01);
                    increaseElectricityConsumption(225);
                }
            }
            case SOUND_ON -> {
                if (isEnable()) {
                    turnOn();
                    increaseDeviceWear(0.01);
                    increaseElectricityConsumption(420);
                }
            }
            case SOUND_PAUSE -> {
                if (isEnable()) {
                    pause();
                    increaseDeviceWear(0.01);
                    increaseElectricityConsumption(5);
                }
            }
            case SOUND_RESUME -> {
                if (isEnable()) {
                    resume();
                    increaseDeviceWear(0.01);
                    increaseElectricityConsumption(5);
                }
            }
            case SOUND_NEXT_TRACK -> {
                if (isEnable()) {
                    nextTrack();
                    increaseDeviceWear(0.01);
                    increaseElectricityConsumption(50);
                }
            }
            case SOUND_OFF -> {
                if (isEnable()) {
                    turnOff();
                    increaseDeviceWear(0.01);
                    increaseElectricityConsumption(10);
                }
            }
            case FLOOD -> setEnable(false);
        }
    }

    /**
     * Method for turning the sound system on
     */
    public void turnOn()
    {
        state.turnOn();
    }

    /**
     * Method for turning the sound system off
     */
    public void turnOff()
    {
        state.turnOff();
    }

    /**
     * Method for playing a music track
     * @param track music track
     */
    public void playTrack(String track)
    {
        state.playTrack(track);
    }

    /**
     * Method for skipping to the next music track
     */
    public void nextTrack()
    {
        state.nextTrack();
    }

    /**
     * Method for skipping to the previous music track
     */
    public void previousTrack()
    {
        state.previousTrack();
    }

    /**
     * Method for pausing the music
     */
    public void pause()
    {
        state.pause();
    }

    /**
     * Method for resuming the music
     */
    public void resume()
    {
        state.resume();
    }

    /**
     * Method for adding a music track to the list
     * @param track new track
     */
    public void addTrack(String track)
    {
        musicTracks.add(track);
    }

    /**
     * Method for removing a music track from the list
     * @param track removed track
     */
    public void removeTrack(String track)
    {
        musicTracks.remove(track);
    }

    /**
     * Method for getting the current state of the sound system
     * @return state
     */
    public State getState()
    {
        return state;
    }

    /**
     * Method for setting the current state of the sound system
     * @param state state
     */
    public void setState(State state)
    {
        this.state = state;
    }

    /**
     * Method for getting the current music track being played
     * @return current track
     */
    public String getCurrentTrack()
    {
        return currentTrack;
    }

    /**
     * Method for setting the current music track being played
     * @param currentTrack current track
     */
    public void setCurrentTrack(String currentTrack)
    {
        this.currentTrack = currentTrack;
    }

    /**
     * Method for getting the list of music tracks
     * @return music tracks
     */
    public List<String> getMusicTracks()
    {
        return new ArrayList<>(musicTracks);
    }

    /**
     * Method for adding a new track to the list
     * @param track new track
     */
    public void addMusicTrack(String track)
    {
        this.musicTracks.add(track);
    }

    @Override
    public String[] accept(Visitor visitor)
    {
        return visitor.visitSoundSystem(this);
    }
}