package model.house;

import java.util.ArrayList;
import java.util.List;

public class EmptyHouse extends House
{
    public EmptyHouse()
    {
        super(List.of("GatesController",
                        "LightController"),
                1,
                1);
    }
}