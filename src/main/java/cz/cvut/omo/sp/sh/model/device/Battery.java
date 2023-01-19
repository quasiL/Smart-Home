package cz.cvut.omo.sp.sh.model.device;

public class Battery {
    private final int capacity;

    public Battery() {
        this.capacity = 100;
    }

    public int getCapacity() {
        return capacity;
    }
}