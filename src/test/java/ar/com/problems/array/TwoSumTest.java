package ar.com.problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    @DisplayName("Should return [0, 1] for nums=[2,7,11,15] and target=9")
    public void twoSum_example1() {
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    @DisplayName("Should return [1, 2] for nums=[3,2,4] and target=6")
    public void twoSum_example2() {
        assertArrayEquals(new int[]{1, 2}, TwoSum.twoSum(new int[]{3, 2, 4}, 6));
    }

    @Test
    @DisplayName("Should return [0, 1] for nums=[3,3] and target=6")
    public void twoSum_example3() {
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSum(new int[]{3, 3}, 6));
    }
}
