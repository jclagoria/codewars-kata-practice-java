package ar.com.problems.files;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

public final class ParallelFileProcessor {

    private ParallelFileProcessor() {}

    public static FileProcessor withCounter(TokenCounter counter) {
        return fileName -> StopWordCounter.countStopWords(fileName, counter);
    }

    public static CompletableFuture<List<WordCount>> countStopWordsAsync(
            List<String> files, FileProcessor processor, Executor executor) {

        List<CompletableFuture<List<WordCount>>> futures = files.stream()
                .map(f -> CompletableFuture.supplyAsync(
                        () -> processor.process(f), executor))
                .toList();

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .flatMap(List::stream)
                        .collect(Collectors.groupingBy(
                                WordCount::word,
                                Collectors.summingInt(WordCount::count)))
                        .entrySet().stream()
                        .map(e -> new WordCount(e.getKey(), e.getValue()))
                        .sorted()
                        .toList());
    }

    public static List<WordCount> countStopWords(
            List<String> files, FileProcessor processor, Executor executor) {
        return countStopWordsAsync(files, processor, executor).join();
    }

}
