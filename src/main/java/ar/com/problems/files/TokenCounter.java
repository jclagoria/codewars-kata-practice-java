package ar.com.problems.files;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
public interface TokenCounter {

    Map<String, Integer> count(String[] tokens, Set<String> stopWords);
}
