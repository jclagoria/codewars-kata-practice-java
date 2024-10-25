package ar.com.problems.string;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringReorderingTest {

    private final List<String[]> sequenceA = List.of( new String[] {"1", "dog" },
            new String[] {"2", "took"},
            new String[] {"4", "Vatsan"},
            new String[] {"5", "for"},
            new String[] {"6", "a"},
            new String[] {"12", "spin"});
    private final List<String[]> sequenceB = List.of(new String[] {"3", "Jake."},
            new String[] {"5", "Chinatown"},
            new String[] {"1", "Forget"},
            new String[] {"4", "It is"},
            new String[] {"2", "it"});
    private final List<String[]> sequenceC = List.of(new String[] {"3", "vatsan!"},
            new String[] {"2", "love"},
            new String[] {"1", "I"});
    private final List<String[]> sequenceD = List.of(new String[] {"0", "Wars"},
            new String[] {"-1", "Code"});

    @Test
    public void testBuildSequence() {
        assertEquals("dog took Vatsan for a spin",
                StringReordering.buildSequence(sequenceA));
        assertEquals("Forget it Jake. It is Chinatown",
                StringReordering.buildSequence(sequenceB));
        assertEquals("I love vatsan!", StringReordering.buildSequence(sequenceC));
        assertEquals("Code Wars", StringReordering.buildSequence(sequenceD));
    }

    @Test
    public void testBuildSequenceList() {
        assertEquals("dog took Vatsan for a spin",
                StringReordering.buildSequenceList(sequenceA));
        assertEquals("Forget it Jake. It is Chinatown",
                StringReordering.buildSequenceList(sequenceB));
        assertEquals("I love vatsan!", StringReordering.buildSequenceList(sequenceC));
        assertEquals("Code Wars", StringReordering.buildSequenceList(sequenceD));
    }


}