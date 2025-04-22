package ar.com.problems.array;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * Scenario
 * the rhythm of beautiful musical notes is drawing a Pendulum
 *
 * Beautiful musical notes are the Numbers
 *
 * Task
 * Given an array/list [] of n integers , Arrange them in a way similar to the to-and-fro movement of a Pendulum
 *
 * The Smallest element of the list of integers , must come in center position of array/list.
 *
 * The Higher than smallest , goes to the right .
 * The Next higher number goes to the left of minimum number and So on , in a to-and-fro manner similar to that of a Pendulum.
 * Notes
 * Array/list size is at least 3 .
 *
 * In Even array size , The minimum element should be moved to (n-1)/2 index (considering that indexes start from 0)
 *
 * Repetition of numbers in the array/list could occur , So (duplications are included when Arranging).
 *
 * Input >> Output Examples:
 * pendulum ([6, 6, 8 ,5 ,10]) ==> [10, 6, 5, 6, 8]
 * Explanation:
 * Since , 5 is the The Smallest element of the list of integers , came in The center position of array/list
 *
 * The Higher than smallest is 6 goes to the right of 5 .
 *
 * The Next higher number goes to the left of minimum number and So on .
 *
 * Remember , Duplications are included when Arranging , Don't Delete Them .
 *
 * pendulum ([-9, -2, -10, -6]) ==> [-6, -10, -9, -2]
 * Explanation:
 * Since , -10 is the The Smallest element of the list of integers , came in The center position of array/list
 *
 * The Higher than smallest is -9 goes to the right of it .
 *
 * The Next higher number goes to the left of -10 , and So on .
 *
 * Remeber , In Even array size , The minimum element moved to (n-1)/2 index (considering that indexes start from 0) .
 *
 * pendulum ([11, -16, -18, 13, -11, -12, 3, 18]) ==> [13, 3, -12, -18, -16, -11, 11, 18]
 * Explanation:
 * Since , -18 is the The Smallest element of the list of integers , came in The center position of array/list
 *
 * The Higher than smallest is -16 goes to the right of it .
 *
 * The Next higher number goes to the left of -18 , and So on .
 *
 * Remember , In Even array size , The minimum element moved to (n-1)/2 index (considering that indexes start from 0) .
 */
public class ThePoetAndThePendulum {

    /**
     * The Poet and The Pendulum.
     * Given an array/list [] of n integers, Arrange them in a way similar to the to-and-fro movement of a Pendulum
     * The Smallest element of the list of integers, must come in center position of array/list.
     * The Higher than smallest, goes to the right.
     * The Next higher number goes to the left of minimum number and So on, in a to-and-fro manner similar to that of a Pendulum.
     * @param values the input array
     * @return the modified array
     */
    public static int[] pendulum(final int[] values) {

        int n = values.length;
        int[] sorted = Arrays.copyOf(values, n);
        Arrays.sort(sorted);

        int[] result = new int[n];

        // calculate the center of the array
        int center = (n - 1) / 2;

        // initialize the left and right pointers
        int left = center;
        int right = center + 1;

        // loop through the array and fill the result array
        for (int i = 0; i < n; i++) {
            // if the index is even, fill the left side
            if ((i & 1) == 0) {
                result[left--] = sorted[i];
            } else {
                // if the index is odd, fill the right side
                result[right++] = sorted[i];
            }
        }

        return result;
    }

    /**
     * Arranges the elements of the array in a 'pendulum' order.
     * The smallest element is placed in the center, and elements are placed alternately
     * to the left and right of the center in increasing order.
     *
     * @param values the input array of integers
     * @return the array arranged in pendulum order
     */
    public static int[] pendulumStream(int[] values) {
        // Create a sorted copy of the input array
        final int[] sortedValues = values.clone();
        Arrays.sort(sortedValues);

        // Determine the starting seed based on even or odd length of the array
        int seed = (sortedValues.length % 2 == 0) ? (sortedValues.length - 2) : (sortedValues.length - 1);

        // Define a function to generate positions for the pendulum arrangement
        IntUnaryOperator function = i -> (i == 0) ? 1 :
                (i % 2 == 0) ? (i - 2) :
                (i + 2);

        // Generate the positions array for pendulum arrangement
        int[] positions = IntStream.iterate(seed, function)
                .limit(sortedValues.length)
                .toArray();

        // Map the sorted values to the pendulum positions and return the result
        return IntStream.range(0, sortedValues.length)
                .map(i -> sortedValues[positions[i]])
                .toArray();
    }
}
