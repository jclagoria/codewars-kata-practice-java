package ar.com.problems.booleans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectPangramTest {

    @Test
    void testValidPangrams() {
        assertTrue(DetectPangram.check("The quick brown fox jumps over the lazy dog"));
        assertTrue(DetectPangram.check("Pack my box with five dozen liquor jugs"));
        assertTrue(DetectPangram.check("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertTrue(DetectPangram.check("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void testIncompleteSentences() {
        assertFalse(DetectPangram.check("Hello world"));
        assertFalse(DetectPangram.check("The quick brown fox jumps"));
        assertFalse(DetectPangram.check("A quick movement of the enemy will jeopardize"));
    }

    @Test
    void testEdgeCases() {
        assertFalse(DetectPangram.check(""));
        assertFalse(DetectPangram.check(null));
        assertTrue(DetectPangram.check("Cwm fjord bank glyphs vext quiz")); // valid obscure pangram
    }

    @Test
    void testWithPunctuationAndDigits() {
        assertTrue(DetectPangram.check("The quick brown fox jumps over the lazy dog!123"));
        assertFalse(DetectPangram.check("1234567890,./;'[]\\=-`"));
    }

    @Test
    void testValidPangramsFunctional() {
        assertTrue(DetectPangram.checkFunctional("The quick brown fox jumps over the lazy dog"));
        assertTrue(DetectPangram.checkFunctional("Pack my box with five dozen liquor jugs"));
        assertTrue(DetectPangram.checkFunctional("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertTrue(DetectPangram.checkFunctional("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void testIncompleteSentencesFunctional() {
        assertFalse(DetectPangram.checkFunctional("Hello world"));
        assertFalse(DetectPangram.checkFunctional("The quick brown fox jumps"));
        assertFalse(DetectPangram.checkFunctional("A quick movement of the enemy will jeopardize"));
    }

    @Test
    void testEdgeCasesFunctional() {
        assertFalse(DetectPangram.checkFunctional(""));
        assertFalse(DetectPangram.checkFunctional(null));
        assertTrue(DetectPangram.checkFunctional("Cwm fjord bank glyphs vext quiz")); // valid obscure pangram
    }

    @Test
    void testWithPunctuationAndDigitsFunctional() {
        assertTrue(DetectPangram.checkFunctional("The quick brown fox jumps over the lazy dog!123"));
        assertFalse(DetectPangram.checkFunctional("1234567890,./;'[]\\=-`"));
        assertFalse(DetectPangram.checkFunctional("1234567890,./;'[]\\=-`"));
    }


}