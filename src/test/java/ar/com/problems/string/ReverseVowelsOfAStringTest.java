package ar.com.problems.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseVowelsOfAStringTest {

    @Test
    @DisplayName("Should send a string IceCreAm and return AceCreIm")
    public void testReverseVowel_Success_example1(){
        assertEquals("AceCreIm", ReverseVowelsOfAString.reverseVowels("IceCreAm"));
    }

    @Test
    @DisplayName("Should send a string leetcode and return leotcede")
    public void testReverseVowel_Success_example2(){
        assertEquals("leotcede", ReverseVowelsOfAString.reverseVowels("leetcode"));
    }

}