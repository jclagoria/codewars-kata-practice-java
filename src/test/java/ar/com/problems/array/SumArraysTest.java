package ar.com.problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumArraysTest {

    @Test
    @DisplayName("Should run with all the test in green, solution using loop")
    public void sumArrays_firstTest() {
        assertEquals(0,  SumArrays.sum(new double[] { }),                1e-4);
        assertEquals(-2.398, SumArrays.sum(new double[] {-2.398}),           1e-4);
        assertEquals(6,      SumArrays.sum(new double[] {1, 2, 3}),          1e-4);
        assertEquals(6.6,    SumArrays.sum(new double[] {1.1, 2.2, 3.3}),    1e-4);
        assertEquals(9.2,    SumArrays.sum(new double[] {1, 5.2, 4, 0, -1}), 1e-4);
        assertEquals(320,    SumArrays.sum(new double[] {30, 89, 100, 101}), 1e-4);
    }

    @Test
    @DisplayName("Should run with all the test in green, solution using Stream")
    public void sumArrays_secondTest() {
        assertEquals(0,  SumArrays.sumStreams(new double[] { }),                1e-4);
        assertEquals(-2.398, SumArrays.sumStreams(new double[] {-2.398}),           1e-4);
        assertEquals(6,      SumArrays.sumStreams(new double[] {1, 2, 3}),          1e-4);
        assertEquals(6.6,    SumArrays.sumStreams(new double[] {1.1, 2.2, 3.3}),    1e-4);
        assertEquals(9.2,    SumArrays.sumStreams(new double[] {1, 5.2, 4, 0, -1}), 1e-4);
        assertEquals(320,    SumArrays.sumStreams(new double[] {30, 89, 100, 101}), 1e-4);
    }

}