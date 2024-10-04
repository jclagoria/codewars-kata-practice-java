package ar.com.problems.array;

import java.util.stream.IntStream;

/**
 * Build a function that returns an array of integers from n to 1 where n > 0.
 * Example : n=5 --> [5,4,3,2,1]
 */
public class ReversedSequence {

    public static int[] reverse(int n){
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = n - i;
        }
        return result;
    }

    public static int[] reverseStreamRange(int n) {
        return IntStream.range(-n, 0).map(Math::abs).toArray();
    }

    public static int[] reverseStreamRangeClose(int n) {
        return IntStream.rangeClosed(-n, 0).map(Math::abs).limit(n).toArray();
    }

}
