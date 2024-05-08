package ar.com.problems.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveRepeatedWordsTest extends BaseTest {

    @Test
    public void removeRepeatedFirstCase() {
        assertEquals("Goodbye bye world",
                RemoveRepeatedWords.removeREpeated(5, "Goodbye bye bye world world world"));

    }

    @Test
    public void removeRepeatedSecondCase() {
        assertEquals("in inthe",
                RemoveRepeatedWords.removeREpeated(5, "in inthe"));

    }

    @Test
    public void removeRepeatedThirdCase() {
        assertEquals("Reya is the best player in eye game",
                RemoveRepeatedWords.removeREpeated(5, "Reya is is the the best player in eye eye game"));

    }
}