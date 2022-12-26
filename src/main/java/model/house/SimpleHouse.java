package model.house;

import java.util.List;

public class SimpleHouse extends House
{
    public SimpleHouse()
    {
        super(List.of("GatesController",
                        "LightController",
                        "Signaling",
                        "ClimateController",
                        "SoundSystem",
                        "WaterCounter",
                        "HomeAssistant"),
                2,
                3);
    }
}