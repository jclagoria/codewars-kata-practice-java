package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CuckooClockTest {

    @Test
    void simpleTests()  {
        final List<String> initialTimes = Arrays.asList("07:22", "12:22", "01:30", "04:01", "03:38");
        final List<Integer> chimes = Arrays.asList(1, 2, 2, 10, 19);
        final List<String> expectedTimes = Arrays.asList("07:30", "12:45", "01:45", "05:30", "06:00");

        for (int i = 0; i < initialTimes.size(); i++) {
            assertEquals(expectedTimes.get(i), CuckooClock.cuckooClock(initialTimes.get(i), chimes.get(i)));
        }
    }

    @Test
    void hourTests()  { // Test case where the starting time is 00, i.e. on the hour
        final List<String> initialTimes = Arrays.asList("10:00", "10:00", "10:00", "10:00", "10:00");
        final List<Integer> chimes = Arrays.asList(1, 10, 11, 13, 20);
        final List<String> expectedTimes = Arrays.asList("10:00", "10:00", "10:15", "10:45", "11:00");

        for (int i = 0; i < initialTimes.size(); i++) {
            assertEquals(expectedTimes.get(i), CuckooClock.cuckooClock(initialTimes.get(i), chimes.get(i)));
        }
    }

    @Test
    void twelveTests()  { // Test going from twelve to one
        final List<String> initialTimes = Arrays.asList("12:30", "12:30", "12:30", "12:30", "09:53");
        final List<Integer> chimes = Arrays.asList(1, 2, 3, 4, 50);
        final List<String> expectedTimes = Arrays.asList("12:30", "12:45", "01:00", "01:15", "02:30");

        for (int i = 0; i < initialTimes.size(); i++) {
            assertEquals(expectedTimes.get(i), CuckooClock.cuckooClock(initialTimes.get(i), chimes.get(i)));
        }
    }

    @Test
    void aroundTheClockTests()  { // Test going more than 12 hours ahead
        final List<String> initialTimes = Arrays.asList("08:17", "08:17", "08:17", "08:17", "08:17");
        final List<Integer> chimes = Arrays.asList(113, 114, 115, 150, 200);
        final List<String> expectedTimes = Arrays.asList("08:00", "08:15", "08:30", "11:00", "05:45");

        for (int i = 0; i < initialTimes.size(); i++) {
            assertEquals(expectedTimes.get(i), CuckooClock.cuckooClock(initialTimes.get(i), chimes.get(i)));
        }
    }

}