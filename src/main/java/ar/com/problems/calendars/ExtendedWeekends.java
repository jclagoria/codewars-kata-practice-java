package ar.com.problems.calendars;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * If the first day of the month is a Friday, it is likely that the month will have an Extended Weekend.
 * That is, it could have five Fridays, five Saturdays and five Sundays.
 *
 * In this Kata, you will be given a start year and an end year. Your task will be to find months that
 * have extended weekends and return:
 *
 * - The first and last month in the range that has an extended weekend
 * - The number of months that have extended weekends in the range, inclusive of start year and end year.
 * For example:
 *
 * solve(2016,2020) = ["JANUARY","MAY","5"]. //The months are: Jan 2016, Jul 2016, Dec 2017, Mar 2019 and May 2020
 * More examples in test cases. Good luck!
 */
public class ExtendedWeekends {

    public static String[] getExtendedWeekends(int startYear, int endYear){

        LocalDate startDate = LocalDate.of(startYear, 1,1);

        var extendedWeekendMonths = new LinkedList<String>();

        while(startDate.getYear() <= endYear) {

            LocalDate lastDayOfMonth = startDate.withDayOfMonth(startDate.lengthOfMonth());

            if(startDate.getDayOfWeek().equals(DayOfWeek.FRIDAY) &&
                    lastDayOfMonth.getDayOfWeek().equals(DayOfWeek.SUNDAY) ) {
                extendedWeekendMonths.add(startDate.getMonth().name());
            }

            startDate = startDate.plusMonths(1);
        }

        return new String[]{extendedWeekendMonths.getFirst(),
                extendedWeekendMonths.getLast(),
                String.valueOf(extendedWeekendMonths.size())};
    }


    public static String[] getExtendedWeekendVersion(int a, int b) {
        var months = new LinkedList<String>();
        while (a <= b) {
            for (Month month : Month.values()) {
                if (hasExtendedWeekend(month, a)) {
                    months.add(month.toString());
                }
            }
            a++;
        }
        return new String[]{months.getFirst(),
                months.getLast(),
                String.valueOf(months.size())};
    }

    private static boolean hasExtendedWeekend(Month month, int year) {
        int days = month.length(Year.isLeap(year));
        return LocalDate.of(year, month, 1).getDayOfWeek().equals(DayOfWeek.FRIDAY) &&
                LocalDate.of(year, month, days).getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    public static String[] getExtendedWeekendsUsingRangeClosed(int startYear, int endYear) {
        var extendedWeekendMonths = new LinkedList<String>();

        IntStream.rangeClosed(startYear, endYear)
                .forEach(year -> {
                    IntStream.rangeClosed(1, 12).forEach(month -> {
                        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
                        LocalDate lastDayOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());

                        if(firstDayOfMonth.getDayOfWeek() == DayOfWeek.FRIDAY
                                && lastDayOfMonth.getDayOfWeek() == DayOfWeek.SUNDAY) {
                            extendedWeekendMonths.add(firstDayOfMonth.getMonth().name());
                        }

                    });
                });

        return new String[] {
                extendedWeekendMonths.getFirst(),
                extendedWeekendMonths.getLast(),
                String.valueOf(extendedWeekendMonths.size())
        };
    }


}
