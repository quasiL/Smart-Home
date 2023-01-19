package cz.cvut.omo.sp.sh.model.device;

import java.util.Random;

public class NetworkSettings {
    private final int max;
    private final int min;
    private final String address;
    private final Random random;

    public NetworkSettings() {
        max = 255;
        min = 0;
        random = new Random();
        this.address = "" + getRandomNumber() + "." + getRandomNumber() + "." + getRandomNumber() + "." + getRandomNumber();
    }

    private int getRandomNumber() {
        return random.nextInt(max - min);
    }

    public String getAddress() {
        return address;
    }
}