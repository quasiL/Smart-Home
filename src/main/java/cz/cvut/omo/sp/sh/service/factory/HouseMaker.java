package cz.cvut.omo.sp.sh.service.factory;

import cz.cvut.omo.sp.sh.model.house.House;
import cz.cvut.omo.sp.sh.service.builder.Director;

public abstract class HouseMaker {
    /**
     * Director class has all the methods for creating houses
     */
    protected final Director director;

    protected HouseMaker() {
        this.director = new Director();
    }

    /**
     * Method for creating a House
     *
     * @return House
     */
    public abstract House createHouse();
}