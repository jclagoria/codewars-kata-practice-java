package ar.com.problems.string;

import static org.junit.Assert.assertEquals;

public class BaseTest {

    public void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    public void testing(String message, int expected, int actual) {
        assertEquals(message ,expected, actual);
    }
}
