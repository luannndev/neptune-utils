package dev.luan.javautility.common;

import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@UtilityClass
public class DateUtility {

    public final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy, HH:mm", Locale.GERMAN);
    public final SimpleDateFormat HOUR_AND_MINUTES_FORMAT = new SimpleDateFormat("HH:mm", Locale.GERMAN);


    /**
     * Parses a given string representation of time using the default date format.
     *
     * @param time the string representation of time to parse
     * @return the parsed Date object
     * @throws ParseException if the string cannot be parsed as a Date using the default date format
     */
    public Date parseDefaultTime(String time) throws ParseException {
        return DATE_FORMAT.parse(time);
    }

    /**
     * Parses a given string representation of time using the default date format or falls back to parsing using a different format.
     *
     * @param time the string representation of time to parse
     * @return the parsed Date object
     * @throws ParseException if the string cannot be parsed as a Date using any of the supported formats
     */
    public Date parseDynamic(String time) throws ParseException {
        Date date;
        try {
            date = DATE_FORMAT.parse(time);
        } catch (ParseException ignored) {
            date = parseDefaultTime(time);
        }
        return date;
    }


    /**
     * Parses a given string representation of time in hours and minutes format.
     *
     * @param time the string representation of time to parse (in HH:mm format)
     * @return the parsed Date object with the specified hours and minutes
     * @throws ParseException if the string cannot be parsed as a Date using the hours and minutes format
     */
    public Date parseHoursAndMinutes(String time) throws ParseException {
        Date parsedTime = HOUR_AND_MINUTES_FORMAT.parse(time);

        Calendar calendar = Calendar.getInstance();

        Calendar timeCalendar = Calendar.getInstance();
        timeCalendar.setTime(parsedTime);
        int hours = timeCalendar.get(Calendar.HOUR_OF_DAY);
        int minutes = timeCalendar.get(Calendar.MINUTE);

        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);

        return calendar.getTime();
    }
}
