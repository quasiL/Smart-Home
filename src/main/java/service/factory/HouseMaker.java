package service.factory;

import model.house.House;
import service.builder.Director;

public abstract class HouseMaker
{
    protected final Director director;

    public HouseMaker()
    {
        this.director = new Director();
    }

    public abstract House createHouse();
}
