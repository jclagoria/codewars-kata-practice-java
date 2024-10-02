package ar.com.problems.numbers;

import ar.com.problems.string.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfCubesTest extends BaseTest {

    @Test
    public void testSumOfCubes() {
        assertEquals(1,SumOfCubes.sumCubes(1));
        assertEquals(9,SumOfCubes.sumCubes(2));
        assertEquals(36,SumOfCubes.sumCubes(3));
        assertEquals(100,SumOfCubes.sumCubes(4));
        assertEquals(3025, SumOfCubes.sumCubes(10));
        assertEquals(58155876,SumOfCubes.sumCubes(123));
    }

    @Test
    public void testSumCubesByLongStream() {
        assertEquals(1,SumOfCubes.sumCubesByLongStream(1));
        assertEquals(9,SumOfCubes.sumCubesByLongStream(2));
        assertEquals(36,SumOfCubes.sumCubesByLongStream(3));
        assertEquals(100,SumOfCubes.sumCubesByLongStream(4));
        assertEquals(3025, SumOfCubes.sumCubesByLongStream(10));
        assertEquals(58155876,SumOfCubes.sumCubesByLongStream(123));
    }

}