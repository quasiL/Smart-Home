package service.visitor;

import model.device.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFExportElectricityConsumption implements Visitor
{
    private final String file;
    private final Font catFont;
    private final Font smallBold;
    private final Font subFont;

    public PDFExportElectricityConsumption()
    {
        file = "reports/ElectricityConsumptionPdf_" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH_mm_ss")) + ".pdf";
        catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    }

    public void export(List<Device> devices)
    {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addTitlePage(document);

            PdfPTable table = new PdfPTable(3);

            PdfPCell c1 = new PdfPCell(new Phrase("Device Name"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Room"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Total Consumption, W"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            table.setHeaderRows(1);

            for (Device device : devices) {
                table.addCell(device.accept(this)[0]);
                table.addCell(device.accept(this)[1]);
                table.addCell(device.accept(this)[2]);
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addEmptyLine(Paragraph paragraph, int number)
    {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private void addTitlePage(Document document) throws DocumentException
    {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Total Electricity Consumption in the house report", catFont));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), smallBold));

        document.add(preface);
        document.newPage();
    }

    @Override
    public String[] visitClimateController(ClimateController climateController)
    {
        return new String[]{
                climateController.getName(),
                Integer.toString(climateController.getRoom()),
                Integer.toString(climateController.getElectricityConsumption())
        };
    }

    @Override
    public String[] visitGateController(GateController gateController)
    {
        return new String[]{
                gateController.getName(),
                Integer.toString(gateController.getRoom()),
                Integer.toString(gateController.getElectricityConsumption())
        };
    }

    @Override
    public String[] visitLightController(LightController lightController)
    {
        return new String[]{
                lightController.getName(),
                Integer.toString(lightController.getRoom()),
                Integer.toString(lightController.getElectricityConsumption())
        };
    }

    @Override
    public String[] visitWaterController(WaterController waterController)
    {
        return new String[]{
                waterController.getName(),
                Integer.toString(waterController.getRoom()),
                Integer.toString(waterController.getElectricityConsumption())
        };
    }

    @Override
    public String[] visitSoundSystem(SoundSystem soundSystem)
    {
        return new String[]{
                soundSystem.getName(),
                Integer.toString(soundSystem.getRoom()),
                Integer.toString(soundSystem.getElectricityConsumption())
        };
    }

    @Override
    public String[] visitSignaling(Signaling signaling)
    {
        return new String[]{
                signaling.getName(),
                Integer.toString(signaling.getRoom()),
                Integer.toString(signaling.getElectricityConsumption())
        };
    }

    @Override
    public String[] visitSmokeDetector(SmokeDetector smokeDetector)
    {
        return new String[]{
                smokeDetector.getName(),
                Integer.toString(smokeDetector.getRoom()),
                Integer.toString(smokeDetector.getElectricityConsumption())
        };
    }

    @Override
    public String[] visitTemperatureSensor(TemperatureSensor temperatureSensor)
    {
        return new String[]{
                temperatureSensor.getName(),
                Integer.toString(temperatureSensor.getRoom()),
                Integer.toString(temperatureSensor.getElectricityConsumption())
        };
    }
}