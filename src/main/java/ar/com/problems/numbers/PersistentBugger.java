package ar.com.problems.numbers;

import java.util.Arrays;

/**
 * Write a function, persistence, that takes in a positive parameter num and returns its multiplicative
 * persistence, which is the number of times you must multiply the digits in num until you reach a single digit.
 * For example (Input --> Output):
 * 39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit, there are 3 multiplications)
 * 999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2, there are 4 multiplications)
 * 4 --> 0 (because 4 is already a one-digit number, there is no multiplication)
 */
public class PersistentBugger {

    public static int persistence(long n) {
        int count = 0;

        while (n >= 10) {
            long product = 1;
            while (n > 0) {
                product *= n % 10;
                n /= 10;
            }
            n = product;
            count++;
        }

        return count;
    }


    /**
     * given a positive integer produce its multiplicative persistence
     * @param n a positive integer
     * @return the multiplicative persistence of n
     */
    public static int persistenceRecursive(long n) {
        if (n < 10) {
            return 0;
        }
        return 1 + persistence(multiplyDigits(n));
    }

    /**
     * given an integer produce the product of the given integers digits.
     * example: multiplyDigits(785) = 7 * 8 * 5 = 280
     * @param n
     * @return the product of the digits that comprise n
     */
    private static long multiplyDigits(long n) {
        if (n < 10) {
            return n;
        }

        return n % 10 * multiplyDigits(n / 10);
    }

    public static int persistenceRecursiveStream(long n) {
        if (n < 10) return 0;

        final long newN = Arrays.stream(String.valueOf(n).split(""))
                .mapToLong(Long::valueOf)
                .reduce(1, (acc, next) -> acc * next);

        return persistence(newN) + 1;
    }
}
