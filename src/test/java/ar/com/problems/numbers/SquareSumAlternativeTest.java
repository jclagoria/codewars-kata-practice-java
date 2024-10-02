package ar.com.problems.numbers;

import ar.com.problems.string.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareSumAlternativeTest extends BaseTest {

    @Test
    public void testBasic()
    {
        assertEquals(9, SquareSumAlternative.squareSum(new int[] {1,2,2}));
        assertEquals(5, SquareSumAlternative.squareSum(new int[] {1,2}));
        assertEquals(50, SquareSumAlternative.squareSum(new int[] {5,-3,4}));
        assertEquals(0, SquareSumAlternative.squareSum(new int[] {}));
    }

}