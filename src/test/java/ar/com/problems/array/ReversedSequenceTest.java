package ar.com.problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversedSequenceTest {

    @Test
    @DisplayName("Reverse Loop Test")
    public void testReverseLoop() {
        assertArrayEquals(new int[] {5, 4, 3, 2, 1}, ReversedSequence.reverse(5));
    }

    @Test
    @DisplayName("Reverse Loop Test")
    public void testReverseStreamRangeClose() {
        assertArrayEquals(new int[] {5, 4, 3, 2, 1}, ReversedSequence.reverseStreamRange(5));
    }

    @Test
    @DisplayName("Reverse StreamRange Close Test")
    public void testReverseStreamClose() {
        assertArrayEquals(new int[] {5, 4, 3, 2, 1}, ReversedSequence.reverseStreamRangeClose(5));
    }

}