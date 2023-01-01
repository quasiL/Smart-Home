package service.visitor;

import model.device.*;

public interface Visitor
{
    /**
     * Method for getting the parameters required by the visitor
     * @param climateController device
     * @return array of device parameters
     */
    String[] visitClimateController(ClimateController climateController);

    /**
     * Method for getting the parameters required by the visitor
     * @param gateController device
     * @return array of device parameters
     */
    String[] visitGateController(GateController gateController);

    /**
     * Method for getting the parameters required by the visitor
     * @param lightController device
     * @return array of device parameters
     */
    String[] visitLightController(LightController lightController);

    /**
     * Method for getting the parameters required by the visitor
     * @param waterController device
     * @return array of device parameters
     */
    String[] visitWaterController(WaterController waterController);

    /**
     * Method for getting the parameters required by the visitor
     * @param soundSystem device
     * @return array of device parameters
     */
    String[] visitSoundSystem(SoundSystem soundSystem);

    /**
     * Method for getting the parameters required by the visitor
     * @param signaling device
     * @return array of device parameters
     */
    String[] visitSignaling(Signaling signaling);

    /**
     * Method for getting the parameters required by the visitor
     * @param smokeDetector device
     * @return array of device parameters
     */
    String[] visitSmokeDetector(SmokeDetector smokeDetector);

    /**
     * Method for getting the parameters required by the visitor
     * @param temperatureSensor device
     * @return array of device parameters
     */
    String[] visitTemperatureSensor(TemperatureSensor temperatureSensor);
}