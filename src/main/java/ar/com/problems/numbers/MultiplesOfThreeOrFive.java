package ar.com.problems.numbers;

import java.util.stream.IntStream;

public class MultiplesOfThreeOrFive {

    public static void main(String[] args) {

        System.out.println(getMultiplesOfThreeOfFive(10));
        System.out.println(getOptimalSolution(20));
    }

    private static final int getMultiplesOfThreeOfFive(int number) {

       int sumAllValues = 0;

        for (int i = 1; i < number ; i++) {

            if( (i % 3 == 0) || (i % 5 == 0)) {
                sumAllValues = sumAllValues + i;
            }
        }

        return sumAllValues;
    }

    private static int getOptimalSolution(int number) {

        return IntStream.range(0, number)
                .filter(value -> (value % 3 == 0) || (value == 5))
                .sum();
    }

}
