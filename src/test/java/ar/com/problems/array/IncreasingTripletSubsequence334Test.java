package ar.com.problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncreasingTripletSubsequence334Test {

    @Test
    @DisplayName("Should return True with this entry [1, 2, 3, 4, 5]")
    public void increasingTripletTest_SuccessExample1() {
        int[] input = {1, 2, 3, 4, 5};
        assertTrue(IncreasingTripletSubsequence334.increasingTriplet(input));
    }

    @Test
    @DisplayName("Should return false with this entry [5,4,3,2,1]")
    public void increasingTripletTest_SuccessExample2() {
        int[] input = {5,4,3,2,1};
        assertFalse(IncreasingTripletSubsequence334.increasingTriplet(input));
    }

    @Test
    @DisplayName("Should return true with this entry [2,1,5,0,4,6]")
    public void increasin$$gTripletTest_SuccessExample3() {
        int[] input = {2,1,5,0,4,6};
        assertTrue(IncreasingTripletSubsequence334.increasingTriplet(input));
    }

}