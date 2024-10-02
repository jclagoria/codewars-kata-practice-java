package ar.com.problems.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Find the difference between two collections. The difference means that either the character is present
 * in one collection or it is present in other, but not in both. Return a sorted list with the difference.
 *
 * The collections can contain any character and can contain duplicates.
 *
 * Example
 * A = [a, a, t, e, f, i, j]
 *
 * B = [t, g, g, i, k, f]
 *
 * difference = [a, e, g, j, k]
 */
public class DifferenceBetweenTwoCollections {

    public static List<Character> diff(Collection<Character> a, Collection<Character> b) {

        return Stream.of(a, b).flatMap(Collection::stream).distinct()
                .filter(filterItem -> !(a.contains(filterItem) && b.contains(filterItem)))
                .sorted()
                .collect(Collectors.toList());
    }

}
