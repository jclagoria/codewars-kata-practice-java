package ar.com.problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Task
 * If possible, divide the integers 1,2,…,n into two sets of equal sum.
 *
 * Input
 * A positive integer n <= 1,000,000.
 *
 * Output
 * If it's not possible, return [ ] (Python, Javascript, Swift, Ruby) or ( ) (Python) or [ [],[] ]
 * (Java, C#, C++, Kotlin) or None (Scala) or Nothing (Haskell) or nil (Lua).
 * If it's possible, return two disjoint sets. Each integer from 1 to n must be in one of them.
 * The integers in the first set must sum up to the same value as the integers in the second set.
 * The sets can be returned in a tuple, list, or array, depending on language.
 *
 * Examples:
 * For n = 8, valid answers include:
 * [1, 3, 6, 8], [2, 4, 5, 7] (or [[1, 3, 6, 8], [2, 4, 5, 7]])
 * [8, 1, 3, 2, 4], [5, 7, 6]
 * [7, 8, 3], [6, 1, 5, 4, 2], and others.
 *
 * For n = 9 it is not possible. For example, try [6, 8, 9] and [1, 2, 3, 4, 5, 7],
 * but the first sums to 23 and the second to 22. No other sets work either.
 */
public class TwoSetsOfEqualSum {

    /**
     * Divides the numbers 1, 2, ..., n into two sets of equal sum.
     *
     * @param n A positive integer n <= 1,000,000.
     * @return A list containing two lists representing the two sets of equal sum.
     *         If it's not possible, returns a list of two empty lists.
     */
    public static List<List<Integer>> createTwoSetsOfEqualSum(int n) {
        // Calculate the total sum of numbers from 1 to n
        long total = (long) n * (n + 1) / 2;

        // Initialize two lists to hold the two sets
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        // Check if it's possible to divide the numbers into two sets of equal sum
        if (total % 2 != 0) {
            return List.of(set1, set2);
        }

        // Calculate the target sum for each set
        long target = total / 2;

        // Iterate from n down to 1 to form the sets
        for (int i = n; i >= 1; i--) {
            if (i <= target) {
                // Add the number to set1 if it doesn't exceed the target
                set1.add(i);
                target -= i;
            } else {
                // Otherwise, add it to set2
                set2.add(i);
            }
        }

        // Return the two sets
        return List.of(set1, set2);
    }

}
