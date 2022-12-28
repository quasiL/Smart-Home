import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import model.device.Battery;
import model.device.GateController;
import model.device.NetworkSettings;

public class StrategyTest
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
                0);
    }

    @Test
    @Order(0)
    void checkIfMorningStrategySetByDefault_isMorning_returnsMorningStrategy()
    {
        Assertions.assertEquals(gateController.getStrategy(), "service.strategy.Morning");
    }
}
