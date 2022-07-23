package ar.com.problems.numbers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SquareSum {

    public static void main(String[] args) {

        System.out.println(solutionKata(new int[] {1,2,2}));
        System.out.println(secondSolutionKata(new int[] {1,2,2,3}));
        System.out.println(thridSolutionKata(new int[] {1,2,2}));
    }

    private static int solutionKata(int[] values) {
        return Arrays.stream(values).reduce(0, (a,b) -> a + (b*b));
    }

    private static int secondSolutionKata(int[] values) {
        return IntStream.of(values).map(value -> (int) Math.pow(value, 2)).sum();
    }

    private static int thridSolutionKata(int[] values) {
        return Arrays.stream(values).map(value -> (int)Math.pow(value, 2)).sum();
    }

}
