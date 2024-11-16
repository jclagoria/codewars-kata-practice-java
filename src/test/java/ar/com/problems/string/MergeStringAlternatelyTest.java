package ar.com.problems.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeStringAlternatelyTest {

    @Test
    @DisplayName("Should Return merged test")
    public void mergeAlternatelyTest() {
        assertEquals("apbqcr", MergeStringAlternately.mergeAlternately("abc", "pqr"));
        assertEquals("apbqrs", MergeStringAlternately.mergeAlternately("ab", "pqrs"));
        assertEquals("ab", MergeStringAlternately.mergeAlternately("ab", ""));
    }

}