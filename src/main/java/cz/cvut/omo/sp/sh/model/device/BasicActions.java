package cz.cvut.omo.sp.sh.model.device;

public interface BasicActions {
    /**
     * Method for restarting this device
     */
    void restart();

    /**
     * Method for synchronizing time on this device
     */
    void synchronizeTime();
}