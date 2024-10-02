package ar.com.problems.numbers;

import ar.com.problems.string.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SquareSumTest extends BaseTest {

    @Test
    public void testBasic()
    {
        assertEquals(9, SquareSum.solutionKata(new int[] {1,2,2}));
        assertEquals(5, SquareSum.solutionKata(new int[] {1,2}));
        assertEquals(50, SquareSum.solutionKata(new int[] {5,-3,4}));
        assertEquals(0, SquareSum.solutionKata(new int[] {}));
    }

    @Test
    public void testSecondSolution()
    {
        assertEquals(9, SquareSum.thridSolutionKata(new int[] {1,2,2}));
        assertEquals(5, SquareSum.thridSolutionKata(new int[] {1,2}));
        assertEquals(50, SquareSum.thridSolutionKata(new int[] {5,-3,4}));
        assertEquals(0, SquareSum.thridSolutionKata(new int[] {}));
    }

    @Test
    public void testThirdSolution()
    {
        assertEquals(9, SquareSum.secondSolutionKata(new int[] {1,2,2}));
        assertEquals(5, SquareSum.secondSolutionKata(new int[] {1,2}));
        assertEquals(50, SquareSum.secondSolutionKata(new int[] {5,-3,4}));
        assertEquals(0, SquareSum.secondSolutionKata(new int[] {}));
    }


}