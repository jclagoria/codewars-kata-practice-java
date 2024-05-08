package ar.com.problems.calendars;

import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * The Calendar class is an abstract class that provides methods for converting between a specific instant in time and a set of calendar fields such as YEAR, MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar fields, such as getting the date of the next week.
 *
 * You are given a date. You just need to write the method, , which returns the day on that date. To simplify your task, we have provided a portion of the code in the editor.
 *
 * Function Description
 *
 * Complete the findDay function in the editor below.
 *
 * findDay has the following parameters:
 *
 * int: month
 * int: day
 * int: year
 * Returns
 *
 * string: the day of the week in capital letters
 * Input Format
 *
 * A single line of input containing the space separated month, day and year, respectively, in MM DD YYYY format
 *
 * Constraints
 *
 * Sample Input
 *
 * 08 05 2015
 * Sample Output
 *
 * WEDNESDAY
 */
public class GetEspecificDay {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    private static String[] daysOfWeek = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, day);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);

        Pattern.compile("^.").matcher(" ").replaceFirst(m -> m.group().toUpperCase());

        return calendar.getDisplayName(Calendar.DAY_OF_WEEK,
                Calendar.LONG, new Locale("en", "US")).toUpperCase();
    }

}
