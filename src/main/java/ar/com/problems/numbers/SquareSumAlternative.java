package ar.com.problems.numbers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SquareSumAlternative {

    public static int squareSum(int[] n)
    {
        return IntStream.of(n).map(value -> value * value).sum();
    }

}
