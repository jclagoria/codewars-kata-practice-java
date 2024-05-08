package ar.com.problems.string;

import java.util.stream.IntStream;

/**
 * We define the following terms:
 *
 * Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows:
 * For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.
 *
 * A substring of a string is a contiguous block of characters in the string. For example, the substrings of abc are a, b, c, ab, bc, and abc.
 * Given a string, , and an integer, , complete the function so that it finds the lexicographically smallest and largest substrings of length .
 *
 * Function Description
 *
 * Complete the getSmallestAndLargest function in the editor below.
 *
 * getSmallestAndLargest has the following parameters:
 *
 * string s: a string
 * int k: the length of the substrings to find
 * Returns
 *
 * string: the string ' + "\n" + ' where and are the two substrings
 * Input Format
 *
 * The first line contains a string denoting .
 * The second line contains an integer denoting .
 */
public class SmallestAndLargest {

    public static String getSmallestAndLargest(String s, int k) {

        String smallest = IntStream.rangeClosed(0, s.length() - k)
                .mapToObj(i -> s.substring(i, i + k))
                .min(String::compareTo)
                .orElse("");

        String largest = IntStream.rangeClosed(0, s.length() - k)
                .mapToObj(i -> s.substring(i, i + k))
                .max(String::compareTo)
                .orElse("");

        return smallest + "\n" + largest;
    }


}
