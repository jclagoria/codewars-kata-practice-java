package ar.com.problems.numbers;

import java.util.stream.IntStream;

public class SumFromASingleNumber {

    public static void main(String[] args) {

        System.out.println(oldWaySumNum(1));
        System.out.println(sumUsingIntStream(6));
        System.out.println(sumUsingIntStream(0));

    }

    private static int oldWaySumNum(int n) {

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    private static int sumUsingIntStream(int n) {
        return IntStream.rangeClosed(1, n).sum();
    }

}
