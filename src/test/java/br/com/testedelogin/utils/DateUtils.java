package br.com.testedelogin.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class responsible for date and time formatting operations.
 */
public final class DateUtils {

    /**
     * Default date-time pattern used in the project.
     */
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd-HH-mm-ss";

    /**
     * Private constructor to prevent instantiation.
     */
    private DateUtils() {
        // Utility class
    }

    /**
     * Returns the current date and time formatted using the default pattern:
     * yyyy-MM-dd-HH-mm-ss
     *
     * @return formatted current date and time as String
     */
    public static String getCurrentDateTimeFormatted() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(DEFAULT_PATTERN));
    }
}