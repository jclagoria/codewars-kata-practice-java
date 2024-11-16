package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GCDStringTest {

    @Test
    public void testGcdOfString_SuccessFindMatch() {
        assertEquals("ABC", GCDString.gcdOfString("ABCABC", "ABC"));
        assertEquals("AB", GCDString.gcdOfString("ABABAB", "ABAB"));
    }

    @Test
    public void testGcdOfString_SuccessNotFindMatch() {
        assertEquals("", GCDString.gcdOfString("LEET", "CODE"));
    }

    @Test
    public void testGcdOfStringsAnotherSolution_SuccessFindMatch(){
        assertEquals("ABC", GCDString.gcdOfStringsAnotherSolution("ABCABC", "ABC"));
        assertEquals("AB", GCDString.gcdOfStringsAnotherSolution("ABABAB", "ABAB"));
    }

    @Test
    public void testGcdOfStringsAnotherSolution_SuccessNotFindMatch() {
        assertEquals("", GCDString.gcdOfStringsAnotherSolution("LEET", "CODE"));
    }

}