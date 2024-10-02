package ar.com.problems.numbers;

import ar.com.problems.string.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeginnerSeries3SumOfNumbersTest extends BaseTest {

    @Test
    public void testSum() {
        assertEquals(-1, BeginnerSeries3SumOfNumbers.getSum(0, -1));
        assertEquals(1, BeginnerSeries3SumOfNumbers.getSum(0, 1));
        assertEquals(1, BeginnerSeries3SumOfNumbers.getSum(1, 1));
    }


}