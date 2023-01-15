import cz.cvut.omo.sp.smart_home.model.device.Battery;
import cz.cvut.omo.sp.smart_home.model.device.GateController;
import cz.cvut.omo.sp.smart_home.model.device.NetworkSettings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class StrategyTest
{
    private GateController gateController;

    @BeforeEach
    void createDevicesForTestsManually()
    {
        gateController = new GateController(
                "Test Gate Controller",
                "manufacture",
                "0.0",
                new Battery(),
                new NetworkSettings(),
                0,
                1);
    }

    @Test
    @Order(0)
    void checkIfMorningStrategySetByDefault_isMorning_returnsMorningStrategy()
    {
        Assertions.assertEquals("Morning", gateController.getStrategy());
    }
}
