package cz.cvut.omo.sp.sh.service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

public class HouseLogger
{
    /**
     * Logger
     */
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(HouseLogger.class.getName());

    /**
     * Log filename
     */
    private static final String file = "logs/log_" +
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH_mm_ss")) + ".txt";

    /**
     * Private constructor for utility class
     */
    private HouseLogger()
    {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Method for writing to the log file
     * @param message log message
     */
    public static void log(String message)
    {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            String log = "[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) +
                    "] " + message;
            fileWriter.write(log + '\n');
            System.out.println(log);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error writing to log file", e);
        }
    }
}