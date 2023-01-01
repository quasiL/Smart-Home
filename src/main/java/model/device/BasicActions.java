package model.device;

import service.visitor.Visitor;

public interface BasicActions
{
    /**
     * Method for manual creating a base report about device
     * @param fileName report's name
     */
    void createReports(String fileName);

    /**
     * A method that allows the visitor to bypass devices
     * @param visitor report's creator
     * @return array of device parameters
     */
    String[] accept(Visitor visitor);

    /**
     * Method for restarting this device
     */
    void restart();

    /**
     * Method for synchronizing time on this device
     */
    void synchronizeTime();
}