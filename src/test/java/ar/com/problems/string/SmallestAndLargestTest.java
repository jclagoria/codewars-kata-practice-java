package ar.com.problems.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestAndLargestTest extends BaseTest {

    @Test
    public void getSmallestAndLargestTest() {
        assertEquals("ava\nzav",
                SmallestAndLargest.getSmallestAndLargest("welcometozava", 3));
    }

}