import model.house.House;
import service.factory.ExtendedHouseMaker;
import service.factory.HouseMaker;
import service.visitor.PDFExportElectricityConsumption;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Objects;

public class VisitorTest
{
    private HouseMaker houseMaker;
    private House house;
    private PDFExportElectricityConsumption report;

    @BeforeEach
    void createHouseWithDevices()
    {
        houseMaker = new ExtendedHouseMaker();
        house = houseMaker.createHouse();
    }

    @Test
    @Order(0)
    void checkIfReportCreated_isFileExists_returnsFilesCount()
    {
        File directory = new File("reports/");
        int filesBefore = Objects.requireNonNull(directory.list()).length;
        report = new PDFExportElectricityConsumption();
        report.export(house.getAllDevices());
        Assertions.assertEquals(Objects.requireNonNull(directory.list()).length - 1, filesBefore);
    }
}
