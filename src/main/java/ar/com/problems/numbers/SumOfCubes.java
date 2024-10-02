package ar.com.problems.numbers;

import java.util.stream.LongStream;

public class SumOfCubes {

    public static long sumCubes(long n)
    {
        long sumCubesValue = 0;

        for (long i = 1; i<= n; i++) {
            sumCubesValue += (long) Math.pow(i, 3);
        }

        return sumCubesValue;
    }

    public static long sumCubesByLongStream(long n) {
        return LongStream.rangeClosed(1, n).map( i -> (long) Math.pow(i, 3)).sum();
    }


}
