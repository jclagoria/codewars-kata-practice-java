package ar.com.problems.numbers;

public class YouReASquare {

    public static boolean isSquare(int n) {

        if (n < 0) {
            return false;  // Negative numbers cannot be perfect squares
        }

        // Calculate the square root of n
        int sqrt = (int) Math.sqrt(n);

        // Check if the square of the square root equals the original number
        return sqrt * sqrt == n;
    }

}
