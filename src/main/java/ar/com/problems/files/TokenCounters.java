package ar.com.problems.files;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class TokenCounters {

    private TokenCounters() {}

    public static TokenCounter sequential() {
        return (tokens, stopWords) -> {
            Map<String, Integer> counts = new HashMap<>();
            for (String token : tokens) {
                if (token.isEmpty() || !stopWords.contains(token)) {
                    continue;
                }
                counts.merge(token, 1, Integer::sum);
            }
            return counts;
        };
    }

    public static TokenCounter parallel() {
        return (tokens, stopWords) -> Arrays.stream(tokens)
                .parallel()
                .filter(token -> !token.isEmpty() && stopWords.contains(token))
                .collect(Collectors.groupingByConcurrent(
                        Function.identity(),
                        Collectors.summingInt(token -> 1)));
    }
}
