import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import model.device.Battery;
import model.device.NetworkSettings;
import model.device.ClimateController;
import service.builder.ClimateControllerBuilder;
import service.builder.Director;

public class BuilderTest
{
    private Director director;
    private ClimateController climateController;
    private ClimateControllerBuilder climateControllerBuilder;

    @BeforeEach
    void createDevicesForTestsManually()
    {
        climateController = new ClimateController(
                "Climate Controller",
                "Home Connect Co",
                "3.1",
                new Battery(),
                new NetworkSettings(),
                2);
    }

    // TODO Write parametrized test for all types of devices instead of this
    @Test
    @Order(0)
    void checkIfClimateControllerHasRightAttributes_isAttributesRight_returnsClimateController()
    {
        director = new Director();
        climateControllerBuilder = new ClimateControllerBuilder();
        director.buildClimateController(climateControllerBuilder);
        ClimateController newClimateController = climateControllerBuilder.getResult();
        Assertions.assertEquals(newClimateController.getName(), climateController.getName());
        Assertions.assertEquals(newClimateController.getManufacturer(), climateController.getManufacturer());
        Assertions.assertEquals(newClimateController.getFirmwareVersion(), climateController.getFirmwareVersion());
        Assertions.assertEquals(newClimateController.getGuarantee(), climateController.getGuarantee());
    }

    @Test
    @Order(1)
    void checkIfClimateControllerCreatedRight_areMethodsCallRight_returnsClimateController()
    {
        climateControllerBuilder = Mockito.mock(ClimateControllerBuilder.class);
        director = Mockito.mock(Director.class);
        director.buildClimateController(climateControllerBuilder);
        Mockito.verify(director).buildClimateController(climateControllerBuilder);
        Mockito.when(climateControllerBuilder.getResult()).thenReturn(climateController);
    }
}
