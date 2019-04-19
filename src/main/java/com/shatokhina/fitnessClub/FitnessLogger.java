package com.shatokhina.fitnessClub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class FitnessLogger {
    private final static FitnessLogger LOGGER = new FitnessLogger();
    private final String lineSeparator = System.getProperty("line.separator");

    private FitnessLogger() { }

    public static FitnessLogger getLogger() { return LOGGER; }

    public void log(User user, FitnessService service) {
        try {
            Files.writeString(Paths.get("C:\\temp\\log.txt"), user.toString() + " <" + service + "> "
                    + LocalDateTime.now().format(ISO_LOCAL_DATE_TIME) + lineSeparator, CREATE, APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}