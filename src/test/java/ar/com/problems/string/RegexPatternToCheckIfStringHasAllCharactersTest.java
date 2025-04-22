package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class RegexPatternToCheckIfStringHasAllCharactersTest {

    @Test
    public void sampleTests() {
        String abc = "abc";
        String regex = RegexPatternToCheckIfStringHasAllCharacters.regexContainsAll(abc);
        Pattern pattern = Pattern.compile(regex);
        assertTrue(pattern.matcher("bca").find(), assertionMsg("bca",abc,regex));
        assertTrue(pattern.matcher("baczzz").find(), assertionMsg("baczzz",abc,regex));
        assertFalse(pattern.matcher("ac").find(), assertionMsg("ac",abc,regex));
        assertFalse(pattern.matcher("bc").find(), assertionMsg("bc",abc,regex));
        assertFalse(pattern.matcher("cb").find(), assertionMsg("cb",abc,regex));
    }

    @Test
    public void sampleTestsOneLinerStyle() {
        String abc = "abc";
        String regex = RegexPatternToCheckIfStringHasAllCharacters.regexContainsAllOneLinerStyle(abc);
        Pattern pattern = Pattern.compile(regex);
        assertTrue(pattern.matcher("bca").find(), assertionMsg("bca",abc,regex));
        assertTrue(pattern.matcher("baczzz").find(), assertionMsg("baczzz",abc,regex));
        assertFalse(pattern.matcher("ac").find(), assertionMsg("ac",abc,regex));
        assertFalse(pattern.matcher("bc").find(), assertionMsg("bc",abc,regex));
        assertFalse(pattern.matcher("cb").find(), assertionMsg("cb",abc,regex));
    }

    private String assertionMsg(String test, String letters, String regex) {
        return String.format("Checking if %s contains all characters in %s with your pattern %s",test,letters,regex);
    }

    @Test
    public void testEmptyInput() {
        String input = "";
        String pattern = RegexPatternToCheckIfStringHasAllCharacters.regexContainsAll(input);
        assertEquals(".*", pattern);
    }


}