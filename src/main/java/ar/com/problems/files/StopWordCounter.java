package ar.com.problems.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Counts occurrences of 37 English stop words in a text file.
 *
 * <h3>Target words</h3>
 * <pre>
 * the, and, in, of, a, an, to, is, with, on, for, it, this, that,
 * by, from, as, at, be, was, were, are, or, but, not, so, if, then,
 * than, can, could, would, should, will, shall, may, might
 * </pre>
 *
 * <h3>Processing</h3>
 * <ol>
 *   <li>Read full file via {@link Files#readString(Path)}</li>
 *   <li>Normalize: lowercase, strip punctuation (keep apostrophes), split on whitespace</li>
 *   <li>Filter tokens against the target word set</li>
 *   <li>Count occurrences, sort by frequency (desc) then word (asc)</li>
 *   <li>Return an immutable {@link List} of {@link WordCount}</li>
 * </ol>
 */
public final class StopWordCounter {

    static final Set<String> STOP_WORDS = Set.of(
            "the", "and", "in", "of", "a", "an", "to", "is", "with", "on",
            "for", "it", "this", "that", "by", "from", "as", "at", "be",
            "was", "were", "are", "or", "but", "not", "so", "if", "then",
            "than", "can", "could", "would", "should", "will", "shall",
            "may", "might"
    );

    private StopWordCounter() {}

    public static List<WordCount> countStopWords(String fileName) {
        return countStopWords(fileName, TokenCounters.sequential());
    }

    public static List<WordCount> countStopWords(String fileName, TokenCounter counter) {
        String content = readFile(fileName);
        String[] tokens = normalizeAndTokenize(content);
        Map<String, Integer> stopWordsMap = counter.count(tokens, STOP_WORDS);
        return sortResults(stopWordsMap);
    }

    private static String readFile(String fileName) {
        Path path = Path.of("src", "main", "resources", fileName);
        if (Files.notExists(path)) {
            throw new IllegalArgumentException(fileName + " does not exist");
        }

        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
    }

    static String[] normalizeAndTokenize(String text) {
        return text
                .toLowerCase()
                .replaceAll("[^a-zA-Z0-9']", " ")
                .split("\\s+");
    }

    static List<WordCount> sortResults(Map<String, Integer> counts) {
        return counts
                .entrySet()
                .stream()
                .map(entry ->
                        new WordCount(entry.getKey(), entry.getValue()))
                .sorted()
                .toList();
    }
}
