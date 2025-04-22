package ar.com.problems.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelf238Test {

    @Test
    public void productExceptSelfTest_SuccessExample1() {
        int[] nums = new int[] {1,2,3,4};
        assertArrayEquals(new int[] {24,12,8,6},
                ProductOfArrayExceptSelf238.productExceptSelf(nums));
    }

    @Test
    public void productExceptSelfTest_SuccessExample2() {
        int[] nums = new int[] {-1,1,0,-3,3};
        assertArrayEquals(new int[] {0,0,9,0,0},
                ProductOfArrayExceptSelf238.productExceptSelf(nums));
    }

}