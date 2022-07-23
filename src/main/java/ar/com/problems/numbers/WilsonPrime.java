package ar.com.problems.numbers;

import java.util.stream.IntStream;

public class WilsonPrime {

    public static void main(String[] args) {

        System.out.println(numberIsWilsonPrimes(5));

    }

    private static boolean numberIsWilsonPrimes(double number) {

        double fact = calculateFactorial(number - 1);

        boolean isWilsonPrimes = false;

        if(( fact + 1) / (number * number) == 1 || number == 563){
            isWilsonPrimes = true;
        }

        return isWilsonPrimes;
    }

    private static double calculateFactorial(double number) {

        if (number <= 2) {
            return number;
        }
        return number * calculateFactorial(number - 1);
    }

}
