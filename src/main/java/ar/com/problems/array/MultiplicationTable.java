package ar.com.problems.array;

import java.util.stream.IntStream;

/**
 * Your task, is to create N×N multiplication table, of size provided in parameter.
 * For example, when given size is 3:
 * 1 2 3
 * 2 4 6
 * 3 6 9
 * For the given example, the return value should be:
 * [[1,2,3],[2,4,6],[3,6,9]]
 */
public class MultiplicationTable {

    public static int [][] multiplicationTable(int n){

        int [][] multiTable = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                multiTable[i][j] = (i + 1) * (j + 1);
            }
        }

        return multiTable;
    }

    public static int [][] multiplicationTableStream(int n){

        return IntStream.rangeClosed(1, n)
                .mapToObj(i -> IntStream.rangeClosed(1, n).map(j -> i * j).toArray())
                .toArray(int[][]::new);
    }

}
