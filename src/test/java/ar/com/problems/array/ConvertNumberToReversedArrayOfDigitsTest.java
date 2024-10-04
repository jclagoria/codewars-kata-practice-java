package ar.com.problems.array;

import ar.com.problems.string.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertNumberToReversedArrayOfDigitsTest extends BaseTest {

    @Test
    @DisplayName("First Test")
    public void tests() {
        assertArrayEquals(new int[] {1, 3, 2, 5, 3}, ConvertNumberToReversedArrayOfDigits.digitize(35231));
        assertArrayEquals(new int[] {0}, ConvertNumberToReversedArrayOfDigits.digitize(0));
    }

    @Test
    @DisplayName("Best Solution")
    public void testsBestSolution() {
        assertArrayEquals(new int[] {1, 3, 2, 5, 3}, ConvertNumberToReversedArrayOfDigits.digitizeIntStream(35231));
        assertArrayEquals(new int[] {0}, ConvertNumberToReversedArrayOfDigits.digitizeIntStream(0));
    }

}