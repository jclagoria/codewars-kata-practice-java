package ar.com.problems.files;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StopWordCounterTest {

    // ── WordCount record ──────────────────────────────────────

    @Test
    void wordCountCompareTo_sortsByCountDescending() {
        WordCount a = new WordCount("the", 5);
        WordCount b = new WordCount("and", 3);
        assertTrue(a.compareTo(b) < 0, "higher count should come first");
    }

    @Test
    void wordCountCompareTo_breaksTiesAlphabetically() {
        WordCount a = new WordCount("and", 5);
        WordCount b = new WordCount("the", 5);
        assertTrue(a.compareTo(b) < 0, "'and' should come before 'the'");
    }

    // ── Tokenization ──────────────────────────────────────────

    @Test
    void normalizeAndTokenize_lowercasesText() {
        String[] tokens = StopWordCounter.normalizeAndTokenize("THE And");
        assertThat(tokens).contains("the", "and");
    }

    @Test
    void normalizeAndTokenize_stripsPunctuation() {
        String[] tokens = StopWordCounter.normalizeAndTokenize("the. and? (in)");
        assertThat(tokens).contains("the", "and", "in");
    }

    @Test
    void normalizeAndTokenize_preservesApostrophes() {
        String[] tokens = StopWordCounter.normalizeAndTokenize("it's don't");
        assertThat(tokens).contains("it's", "don't");
    }

    @Test
    void normalizeAndTokenize_splitsOnWhitespace() {
        String[] tokens = StopWordCounter.normalizeAndTokenize("the  and\nin\tof");
        assertThat(tokens).contains("the", "and", "in", "of");
    }

    // ── Counting ──────────────────────────────────────────────

    @Test
    void countTokens_onlyCountsStopWords() {
        String[] tokens = {"the", "rainbow", "and", "xyz", "the"};
        var counts = TokenCounters.sequential().count(tokens, StopWordCounter.STOP_WORDS);
        assertThat(counts)
                .hasSize(2)
                .containsEntry("the", 2)
                .containsEntry("and", 1);
    }

    @Test
    void countTokens_ignoresEmptyStrings() {
        String[] tokens = {"", "the", ""};
        var counts = TokenCounters.sequential().count(tokens, StopWordCounter.STOP_WORDS);
        assertThat(counts).containsOnlyKeys("the");
    }

    @Test
    void countTokens_ignoresNonStopWords() {
        String[] tokens = {"rainbow", "refraction", "droplet"};
        var counts = TokenCounters.sequential().count(tokens, StopWordCounter.STOP_WORDS);
        assertThat(counts).isEmpty();
    }

    // ── Sorting ───────────────────────────────────────────────

    @Test
    void sortResults_returnsDescendingCountAlphaTies() {
        var counts = new java.util.HashMap<String, Integer>();
        counts.put("a", 5);
        counts.put("the", 7);
        counts.put("and", 5);
        var result = StopWordCounter.sortResults(counts);
        assertThat(result)
                .containsExactly(
                        new WordCount("the", 7),
                        new WordCount("a", 5),
                        new WordCount("and", 5)
                );
    }

}