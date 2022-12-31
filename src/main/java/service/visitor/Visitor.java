package service.visitor;

import model.device.*;

public interface Visitor
{
    String[] visitClimateController(ClimateController climateController);

    String[] visitGateController(GateController gateController);

    String[] visitLightController(LightController lightController);

    String[] visitWaterController(WaterController waterController);

    String[] visitSoundSystem(SoundSystem soundSystem);

    String[] visitSignaling(Signaling signaling);

    String[] visitSmokeDetector(SmokeDetector smokeDetector);

    String[] visitTemperatureSensor(TemperatureSensor temperatureSensor);
}