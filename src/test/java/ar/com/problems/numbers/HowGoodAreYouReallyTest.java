package ar.com.problems.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HowGoodAreYouReallyTest {

    @Test
    @DisplayName("Better than Average - Loop")
    public void testBetterThanAverage() {
        assertTrue(HowGoodAreYouReally.betterThanAverage(new int[] {2, 3}, 5));
        assertTrue(HowGoodAreYouReally.betterThanAverage(new int[] {100, 40, 34, 57, 29, 72, 57, 88}, 75));
        assertTrue(HowGoodAreYouReally.betterThanAverage(new int[] {12, 23, 34, 45, 56, 67, 78, 89, 90}, 69));
        assertFalse(HowGoodAreYouReally.betterThanAverage(new int[] {100, 90}, 11));
    }

    @Test
    @DisplayName("Better than Average - IntStream")
    public void testBetterThanAverageStream() {
        assertTrue(HowGoodAreYouReally.betterThanAverageStream(new int[] {2, 3}, 5));
        assertTrue(HowGoodAreYouReally.betterThanAverageStream(new int[] {100, 40, 34, 57, 29, 72, 57, 88}, 75));
        assertTrue(HowGoodAreYouReally.betterThanAverageStream(new int[] {12, 23, 34, 45, 56, 67, 78, 89, 90}, 69));
        assertFalse(HowGoodAreYouReally.betterThanAverageStream(new int[] {100, 90}, 11));
    }

    @Test
    @DisplayName("Better ThanAverage Stream V2 - IntStream")
    public void testBetterThanAverageStreamV2() {
        assertTrue(HowGoodAreYouReally.betterThanAverageStreamV2(new int[] {2, 3}, 5));
        assertTrue(HowGoodAreYouReally.betterThanAverageStreamV2(new int[] {100, 40, 34, 57, 29, 72, 57, 88}, 75));
        assertTrue(HowGoodAreYouReally.betterThanAverageStreamV2(new int[] {12, 23, 34, 45, 56, 67, 78, 89, 90}, 69));
        assertFalse(HowGoodAreYouReally.betterThanAverageStreamV2(new int[] {100, 90}, 11));
    }
}