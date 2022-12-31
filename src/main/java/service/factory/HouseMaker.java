package service.factory;

import model.house.House;
import service.builder.Director;

public abstract class HouseMaker
{
    /**
     * Director class has all the methods for creating houses
     */
    protected final Director director;

    public HouseMaker()
    {
        this.director = new Director();
    }

    /**
     * Method for creating a House
     * @return House
     */
    public abstract House createHouse();
}