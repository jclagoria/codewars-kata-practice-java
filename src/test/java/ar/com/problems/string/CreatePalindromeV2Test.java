package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatePalindromeV2Test {

    @Test
    public void basicTests(){
        assertTrue(CreatePalindromeV2.solve("abba"));
        assertFalse(CreatePalindromeV2.solve("abaazaba"));
        assertTrue(CreatePalindromeV2.solve("abccba"));
    }
}