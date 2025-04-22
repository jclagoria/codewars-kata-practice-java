package ar.com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ProcessFiles {

    private static final Set<String> STOP_WORDS = Set.of(
            "the", "and", "in", "of", "a", "an", "to", "is", "with", "on", "for", "it", "this", "that", "by", "from", "as", "at", "be", "was", "were", "are", "or", "but", "not", "so", "if", "then", "than", "can", "could", "would", "should", "will", "shall", "may", "might"
    );

    public static Map<String, Integer> analyzeFileInResources(String fileName) {
        File file = new File("src/main/resources/" + fileName);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("File not found: " + fileName);
        }

        try {
            Map<String, Integer> wordFrequency = analyzeFile(file);
            return sortAndReturnWordFrequencies(wordFrequency);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Map<String, Integer> analyzeFile(File file) throws IOException {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z0-9\'\s]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty() && !STOP_WORDS.contains(word)) {
                        wordFrequency.compute(word, (k, v) -> v == null ? 1 : v + 1);
                        //wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        return wordFrequency;
    }

    private static Map<String, Integer> sortAndReturnWordFrequencies(Map<String, Integer> wordFrequency) {
        Map<String, Integer> sortedWordFrequency = new LinkedHashMap<>();
        wordFrequency.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> sortedWordFrequency.put(entry.getKey(), entry.getValue()));
        return sortedWordFrequency;
    }

}
