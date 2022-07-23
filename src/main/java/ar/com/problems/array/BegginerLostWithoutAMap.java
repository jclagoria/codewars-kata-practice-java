package ar.com.problems.array;

import java.util.Arrays;


public class BegginerLostWithoutAMap {

    public static void main(String[] args) {

        int[] value = {2,3,4,5,6};

        Arrays.stream(getLostWithoutAMap(value)).forEach(System.out::print);
    }

    private static int[] getLostWithoutAMap(int[] value) {

        return Arrays.stream(value).map(x -> x + x).toArray();
    }

}
