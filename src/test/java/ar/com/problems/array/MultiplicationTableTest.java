package ar.com.problems.array;

import ar.com.problems.string.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class MultiplicationTableTest extends BaseTest {

    @Test
    @DisplayName("n = 3")
    public void test3() {
        int[][] test = {{1,2,3},{2,4,6},{3,6,9}};
        Assertions.assertArrayEquals(test, MultiplicationTable.multiplicationTable(3));
    }

    @Test
    @DisplayName("n = 1")
    public void test1(){
        int[][] test1 = {{1}};
        Assertions.assertArrayEquals(test1, MultiplicationTable.multiplicationTable(1));
    }

    @Test
    @DisplayName("IntStream n = 3")
    public void multiplicationTableIntStream1() {
        int[][] test = {{1,2,3},{2,4,6},{3,6,9}};
        Assertions.assertArrayEquals(test, MultiplicationTable.multiplicationTableStream(3));
    }

    @Test
    @DisplayName("IntStream n = 1")
    public void multiplicationTableIntStream2() {
        int[][] test = {{1}};
        Assertions.assertArrayEquals(test, MultiplicationTable.multiplicationTableStream(1));
    }

    @Test
    @DisplayName("Benchmark")
    public void MultiplicationTableBenchmark() {
        int n = 10;
        int[][] expected = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                expected[i][j] = (i + 1) * (j + 1);
            }
        }

        // Benchmark loop-based method
        long startTimeLoop = System.nanoTime();
        Assertions.assertArrayEquals(expected, MultiplicationTable.multiplicationTable(10));
        long endTimeLoop = System.nanoTime();
        long durationLoop = (endTimeLoop - startTimeLoop) / 1_000_000;  // Convert to milliseconds
        System.out.println("Loop-based approach took - Loop: " + durationLoop + " ms");

        // Benchmark stream-based method
        long startTimeStream = System.nanoTime();
        Assertions.assertArrayEquals(expected, MultiplicationTable.multiplicationTableStream(10));
        long endTimeStream = System.nanoTime();
        long durationStream = (endTimeStream - startTimeStream) / 1_000_000;  // Convert to milliseconds
        System.out.println("Stream-based approach took: " + durationStream + " ms");

    }
}