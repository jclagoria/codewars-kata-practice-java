package ar.com.problems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/***
 * Define a function that removes duplicates from an array of non negative numbers and returns it as a result.
 * The order of the sequence has to stay the same.
 * Examples:
 * Input -> Output
 * [1, 1, 2] -> [1, 2]
 * [1, 2, 1, 1, 3, 2] -> [1, 2, 3]
 */
public class RemoveDuplicatesFromList {

    public static int[] distinct(int[] nums) {

        return Arrays.stream(nums).distinct().toArray();
    }

    public static int[] distinctLinkedHashSet(int[] nums) {

        Set<Integer> uniqueSet = new LinkedHashSet<>();

        for (int num : nums) {
            uniqueSet.add(num);
        }

       return uniqueSet.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Using HashSet for Larger or Unbounded Range (Best for Flexibility with Good Performance)
     * Performance: O(n) (average case) with O(n) space complexity.
     * Space Complexity: O(n)
     * Best for: Situations where the range of numbers is large or unbounded,
     * and you need a balance of performance and flexibility.
     * Readability: Medium — slightly more complex than LinkedHashSet, but still readable.
     * @param arr
     * @return
     */
    public static int[] distinctWithHashSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        int writeIndex = 0;
        for (int num : arr) {
            if (seen.add(num)) { // HashSet adds only unique elements
                arr[writeIndex++] = num;
            }
        }
        return arr;
    }

    public static int[] distinctStream(int[] arr) {
        return Arrays.stream(arr)
                .boxed() // Convert int to Integer to work with Set
                .collect(Collectors
                        .toCollection(LinkedHashSet::new)) // Collect into LinkedHashSet to remove duplicates and preserve order
                .stream()
                .mapToInt(Integer::intValue) // Convert back to int
                .toArray(); // Return as an int array
    }

}
