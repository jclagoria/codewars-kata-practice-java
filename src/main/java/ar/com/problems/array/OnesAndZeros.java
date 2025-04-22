package ar.com.problems.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Given an array of ones and zeroes, convert the equivalent binary value to an integer.
 *
 * Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.
 *
 * Examples:
 *
 * Testing: [0, 0, 0, 1] ==> 1
 * Testing: [0, 0, 1, 0] ==> 2
 * Testing: [0, 1, 0, 1] ==> 5
 * Testing: [1, 0, 0, 1] ==> 9
 * Testing: [0, 0, 1, 0] ==> 2
 * Testing: [0, 1, 1, 0] ==> 6
 * Testing: [1, 1, 1, 1] ==> 15
 * Testing: [1, 0, 1, 1] ==> 11
 * However, the arrays can have varying lengths, not just limited to 4.
 */
public class OnesAndZeros {

    /**
     * Converts a list of binary digits (0s and 1s) to its equivalent integer value.
     *
     * @param binary a list of integers representing binary digits
     * @return the integer value of the binary number
     * @throws IllegalArgumentException if the list contains values other than 0 or 1
     */
    public static int convertBinaryArrayToInt(List<Integer> binary) {
        int result = 0;

        // Iterate over each bit in the binary list
        for (int bit : binary) {
            // Check if the bit is either 0 or 1
            if (bit != 0 && bit != 1) {
                throw new IllegalArgumentException("Array must contain only 0s and 1s");
            }

            // Shift the result left by 1 to make space for the new bit and add the current bit
            result = (result << 1) | bit;
        }

        return result; // Return the computed integer value
    }

    /**
     * Converts a list of binary digits (0s and 1s) to its equivalent integer value using functional programming.
     *
     * @param binary a list of integers representing binary digits
     * @return the integer value of the binary number
     * @throws IllegalArgumentException if the list contains values other than 0 or 1
     */
    public static int binaryArrayToNumberFunctional(List<Integer> binary) {
        // Check if the list contains any values other than 0 or 1
        if (binary.stream().anyMatch(b -> b != 0 && b != 1)) {
            throw new IllegalArgumentException("Array must contain only 0s and 1s");
        }

        // Use the reduce method to compute the integer value of the binary number
        // The reducer function takes two parameters: the accumulator and the current bit
        // The reducer function shifts the accumulator left by 1 to make space for the new bit and adds the current bit
        // The initial value of the accumulator is 0
        return binary.stream()
                .reduce(0, (acc, bit) -> (acc << 1) | bit);
    }

    /**
     * Converts a list of binary digits (0s and 1s) to its equivalent integer value by calculating
     * the weighted sum of bits based on their index positions.
     *
     * @param binary a list of integers representing binary digits
     * @return the integer value of the binary number
     * @throws IllegalArgumentException if the list contains values other than 0 or 1
     */
    public static int binaryArrayToIntByIndex(List<Integer> binary) {
        int n = binary.size(); // Get the size of the binary list

        // Use IntStream to iterate over the index range of the list
        return IntStream.range(0, n)
                .map(i -> {
                    int bit = binary.get(i); // Get the bit at current index

                    // Validate the bit value; it must be either 0 or 1
                    if (bit != 0 && bit != 1) {
                        throw new IllegalArgumentException("Array must contain only 0s and 1s");
                    }

                    // Shift the bit to its proper place value and return it
                    return bit << (n - 1 - i);
                })
                .sum(); // Sum all the computed values to get the final integer
    }

}
