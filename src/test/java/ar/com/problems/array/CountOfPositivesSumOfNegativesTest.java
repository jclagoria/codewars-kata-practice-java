package ar.com.problems.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountOfPositivesSumOfNegativesTest {

    @Test
    public void countPositivesSumNegatives_BasicTest() {
        int[] expectedResult = new int[] {10, -65};
        assertArrayEquals(expectedResult, CountOfPositivesSumOfNegatives
                .countPositivesSumNegatives(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
    }

    @Test
    public void countPositivesSumNegatives_InputWithZeroes() {
        int[] expectedResult = new int[] {8, -50};
        assertArrayEquals(expectedResult, CountOfPositivesSumOfNegatives
                .countPositivesSumNegatives(new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}));
    }

    @Test
    public void countPositivesSumNegatives_EmptyInput() {
        int[] expectedResult = new int[2];
        assertArrayEquals(expectedResult, CountOfPositivesSumOfNegatives
                .countPositivesSumNegatives(new int[2]));
    }

    @Test
    public void countPositivesSumNegatives_NullInput() {
        int[] expectedResult = new int[2];
        assertArrayEquals(expectedResult, CountOfPositivesSumOfNegatives
                .countPositivesSumNegatives(null));
    }

}