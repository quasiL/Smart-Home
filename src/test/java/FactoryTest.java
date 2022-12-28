import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import model.house.EmptyHouse;
import model.house.ExtendedHouse;
import model.house.SimpleHouse;
import service.factory.EmptyHouseMaker;
import service.factory.ExtendedHouseMaker;
import service.factory.SimpleHouseMaker;

public class FactoryTest
{
    private EmptyHouse emptyHouse;
    private SimpleHouse simpleHouse;
    private ExtendedHouse extendedHouse;
    EmptyHouseMaker emptyHouseMaker;
    SimpleHouseMaker simpleHouseMaker;
    ExtendedHouseMaker extendedHouseMaker;

    @BeforeEach
    void createsHouseMakers()
    {
        emptyHouse = new EmptyHouse();
        simpleHouse = new SimpleHouse();
        extendedHouse = new ExtendedHouse();
        emptyHouseMaker = new EmptyHouseMaker();
        simpleHouseMaker = new SimpleHouseMaker();
        extendedHouseMaker = new ExtendedHouseMaker();
    }

    @Test
    @Order(0)
    void checkFloorsInEmptyHouse_isNumberOfFloorsRight_returnsNumberOfRooms()
    {
        Assertions.assertEquals(
                emptyHouse.getNumberOfFloors()*emptyHouse.getNumberOfRoomsPerFloor(),
                emptyHouseMaker.createHouse().getRooms().size()
        );
    }

    @Test
    @Order(1)
    void checkFloorsInSimpleHouse_isNumberOfFloorsRight_returnsNumberOfRooms()
    {
        Assertions.assertEquals(
                simpleHouse.getNumberOfFloors()*simpleHouse.getNumberOfRoomsPerFloor(),
                simpleHouseMaker.createHouse().getRooms().size()
        );
    }

    @Test
    @Order(2)
    void checkFloorsInExtendedHouse_isNumberOfFloorsRight_returnsNumberOfRooms()
    {
        Assertions.assertEquals(
                extendedHouse.getNumberOfFloors()*extendedHouse.getNumberOfRoomsPerFloor(),
                extendedHouseMaker.createHouse().getRooms().size()
        );
    }
}