package ch.makery.address.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateUtil {


    private static final String DATE_PATTERN = "dd.MM.yyyy";


    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static String format(LocalDate date) {
        return (date == null) ? null : DATE_FORMATTER.format(date);
    }


    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null; // Log the exception if necessary
        }
    }


    public static boolean validDate(String dateString) {
        return parse(dateString) != null; // Try to parse the String
    }
}
