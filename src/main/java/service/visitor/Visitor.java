package service.visitor;

import model.device.ClimateController;
import model.device.GateController;
import model.device.LightController;

public interface Visitor
{
    String[] visitClimateController(ClimateController climateController);

    String[] visitGateController(GateController gateController);

    String[] visitLightController(LightController lightController);
}
