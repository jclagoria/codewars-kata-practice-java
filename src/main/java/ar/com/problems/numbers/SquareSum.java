package ar.com.problems.numbers;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Complete the square sum function so that it squares each number passed into it and then sums the results together.
 *
 * For example, for [1, 2, 2] it should return 9
 *
 */
public class SquareSum {

    public static int solutionKata(int[] values) {
        return Arrays.stream(values).reduce(0, (a,b) -> a + (b*b));
    }

    public static int secondSolutionKata(int[] values) {
        return IntStream.of(values).map(value -> (int) Math.pow(value, 2)).sum();
    }

    public static int thridSolutionKata(int[] values) {
        return Arrays.stream(values).map(value -> (int)Math.pow(value, 2)).sum();
    }

}
