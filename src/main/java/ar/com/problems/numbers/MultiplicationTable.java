package ar.com.problems.numbers;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * Your task, is to create N×N multiplication table, of size provided in parameter.
 *
 * For example, when given size is 3:
 *
 * 1 2 3
 * 2 4 6
 * 3 6 9
 * For the given example, the return value should be:
 *
 * [[1,2,3],[2,4,6],[3,6,9]]
 *
 */
public class MultiplicationTable {

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(multiplicationTable(4)));
        System.out.println(Arrays.deepToString(multiplicationTableWithIntStream(5)));

    }
    private static int [][] multiplicationTable(int n){

        int[][] multiplicationTable = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return multiplicationTable;
    }

    private static int[][] multiplicationTableWithIntStream(int n) {

        return IntStream.rangeClosed(1,n)
                .mapToObj(i -> IntStream.rangeClosed(1, n)
                        . map(j -> i * j).toArray())
                .toArray(int[][]::new);
    }

}
