package model.house;

import model.Room;
import java.util.List;

public class ExtendedHouse extends House
{
    private final Room garage = new Room();

    public ExtendedHouse()
    {
        super(List.of("GatesController",
                        "LightController",
                        "Signaling",
                        "ClimateController",
                        "SoundSystem",
                        "WaterCounter",
                        "HomeAssistant",
                        "CarDiagnostic"),
                4,
                5);
    }
}