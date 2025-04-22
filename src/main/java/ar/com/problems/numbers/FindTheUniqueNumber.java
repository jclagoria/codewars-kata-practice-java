package ar.com.problems.numbers;

/**
 * There is an array with some numbers. All numbers are equal except for one. Try to find it!
 *
 * Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
 * Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
 * It’s guaranteed that array contains at least 3 numbers.
 *
 * The tests contain some very huge arrays, so think about performance.
 */
public class FindTheUniqueNumber {

    /**
     * Find the unique number in an array of doubles.
     * The array contains at least 3 numbers and all numbers are equal except for one.
     * @param arr the input array
     * @return the unique number
     */
    public static double findUniq(double arr[]) {
        double candidate;

        // Check the first three elements
        if (arr[0] == arr[1]) {
            // The first two elements are equal, the third element could be the unique one
            candidate = arr[0];
        } else if (arr[0] == arr[2]) {
            // The first and third elements are equal, the second element could be the unique one
            candidate = arr[0];
        } else {
            // The first element is the unique one
            return arr[0];
        }

        // Check the rest of the array
        for (double value : arr) {
            if (value != candidate) {
                // Found the unique number
                return value;
            }
        }

        // Should never reach here
        throw new IllegalArgumentException("No unique number found");
    }

}
