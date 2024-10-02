package ar.com.problems.calendars;

import ar.com.problems.string.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExtendedWeekendsTest extends BaseTest {

    @Test
    public void testGetExtendedWeekends() {
        assertArrayEquals(new String[]{"JANUARY","MAY","5"},ExtendedWeekends.getExtendedWeekends(2016,2020));
        assertArrayEquals(new String[]{"MARCH", "DECEMBER","51"},ExtendedWeekends.getExtendedWeekends(1900,1950));
        assertArrayEquals(new String[]{"AUGUST", "OCTOBER","702"},ExtendedWeekends.getExtendedWeekends(1800,2500));
    }

    @Test
    public void testGetExtendedWeekendVersion() {
        assertArrayEquals(new String[]{"JANUARY","MAY","5"},ExtendedWeekends.getExtendedWeekendVersion(2016,2020));
        assertArrayEquals(new String[]{"MARCH", "DECEMBER","51"},ExtendedWeekends.getExtendedWeekendVersion(1900,1950));
        assertArrayEquals(new String[]{"AUGUST", "OCTOBER","702"},ExtendedWeekends.getExtendedWeekendVersion(1800,2500));
    }

    @Test
    public void testGetExtendedWeekendsUsingRangeClosed() {
        assertArrayEquals(new String[]{"JANUARY","MAY","5"},ExtendedWeekends.getExtendedWeekendsUsingRangeClosed(2016,2020));
        assertArrayEquals(new String[]{"MARCH", "DECEMBER","51"},ExtendedWeekends.getExtendedWeekendsUsingRangeClosed(1900,1950));
        assertArrayEquals(new String[]{"AUGUST", "OCTOBER","702"},ExtendedWeekends.getExtendedWeekendsUsingRangeClosed(1800,2500));
    }

}