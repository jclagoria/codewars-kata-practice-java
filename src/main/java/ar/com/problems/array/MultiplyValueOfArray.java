package ar.com.problems.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MultiplyValueOfArray {

    public static void main(String[] args) {

        int[] value = {1,2,3,4};

        System.out.println(multiplyValueOfArray(value));

    }

    private static int multiplyValueOfArray(int[] value) {

        return IntStream.of(value).reduce(1, (multiplicand,multiplier) -> multiplicand * multiplier);
    }


}
