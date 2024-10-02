package ar.com.problems.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmashWordsTest extends BaseTest {

    @Test
    public void firstTest() {
        assertEquals("hello", SmashWords.smash(new String[] { "hello" }));
        assertEquals("hello world", SmashWords.smash(new String[] { "hello", "world"}));
        assertEquals("hello world this is great", SmashWords.smash(new String[] {"hello", "world", "this", "is", "great"}));
    }

    @Test
    public void smashBuilderTest() {
        assertEquals("hello", SmashWords.smashBuilder(new String[] { "hello" }));
        assertEquals("hello world", SmashWords.smashBuilder(new String[] { "hello", "world"}));
        assertEquals("hello world this is great", SmashWords.smashBuilder(new String[] {"hello", "world", "this", "is", "great"}));
    }

}