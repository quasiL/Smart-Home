package service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HouseLogger
{
    /**
     * Logger
     */
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Logger.class.getName());

    /**
     * Log filename
     */
    private static final String file = "logs/log_" +
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH_mm_ss")) + ".txt";

    /**
     * Method for writing to the log file
     * @param message log message
     */
    public static void log(String message)
    {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) +
                    "] " + message + "\n");
            fileWriter.close();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing to log file", e);
        }
    }
}