package ar.com.problems.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsStringTest {

    @Test
    @DisplayName("Should return a String blue is sky the")
    public void testReverseWordsString_Example1() {
        assertEquals("blue is sky the", ReverseWordsString.reverseWords("the sky is blue"));
    }

    @Test
    @DisplayName("Should return a String world hello")
    public void testReverseWordsString_Example2() {
        assertEquals("world hello", ReverseWordsString.reverseWords("  hello world  "));
    }

    @Test
    @DisplayName("Should return a String example good a")
    public void testReverseWordsString_Example3() {
        assertEquals("example good a", ReverseWordsString.reverseWords("a good   example"));
    }

    @Test
    @DisplayName("Should return a String blue is sky the")
    public void testReverseWordsBestOption_Example1() {
        assertEquals("blue is sky the", ReverseWordsString.reverseWordsBestOption("the sky is blue"));
    }

    @Test
    @DisplayName("Should return a String world hello")
    public void testReverseWordsBestOption_Example2() {
        assertEquals("world hello", ReverseWordsString.reverseWordsBestOption("  hello world  "));
    }

    @Test
    @DisplayName("Should return a String example good a")
    public void testReverseWordsBestOption_Example3() {
        assertEquals("example good a", ReverseWordsString.reverseWordsBestOption("a good   example"));
    }

}