package ar.com.problems.array;

import java.util.ArrayList;
import java.util.List;

/***
 * You are given two positive integers a and b (a < b <= 20000). Complete the function which
 * returns a list of all those numbers in the interval [a, b)
 * whose digits are made up of prime numbers (2, 3, 5, 7) but which are not primes themselves.
 *
 * Be careful about your timing!
 */
public class NotPrimeNumbers {

    private static final int MAX = 20000;
    private static final boolean[] isPrime = sieve(MAX);

    /**
     * The Sieve of Eratosthenes algorithm is an algorithm used to find all primes smaller than n.
     * When the algorithm terminates, all the numbers in the list that are still marked as prime are primes.
     * @param limit The upper limit for the sieve.
     * @return an array where the i-th element is true if i is a prime and false otherwise.
     */
    private static boolean[] sieve(int limit) {
        boolean[] prime = new boolean[limit + 1];

        for (int i = 2; i <= limit; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (prime[i]) {
                // If i is prime, then all its multiples are not primes
                for (int j = i * i; j <= limit; j += i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

    /**
     * This method checks if all the digits of the given number are prime.
     * The method takes an integer as input and returns a boolean.
     * @param n The number to check.
     * @return true if all the digits of the number are prime, false otherwise.
     */
    private static boolean allDigitsPrime(int n) {
        // We loop until there are no more digits in the number
        while (n > 0) {
            int digit = n % 10; // Get the last digit of the number
            // If the digit is not prime, return false
            if (digit != 2 && digit != 3 && digit != 5 && digit != 7) return false;

            // Remove the last digit from the number
            n /= 10;
        }

        // If all the digits are prime, return true
        return true;
    }

    /**
     * Returns a list of all the numbers in the interval [a, b) that
     * have all their digits prime and are not prime themselves.
     * @param a The start of the interval.
     * @param b The end of the interval.
     * @return A list of all the numbers in the interval that satisfy the condition.
     */
    public static List<Integer> notPrimes(int a, int b) {

        List<Integer> result = new ArrayList<>();

        for (int i = a; i < b; i++) {
            // If the number is not prime and all its digits are prime, add it to the result
            if (!isPrime[i] && allDigitsPrime(i)) {
                result.add(i);
            }
        }

        return result; // Do your magic!
    }

}


