package ar.com.problems.numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ShortestPathBinaryMatrixTest {

    @Test
    void exampleCase() {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        assertThat(ShortestPathBinaryMatrix.shortestPath(grid)).isEqualTo(4);
    }

    @Test
    void singleCellZero() {
        assertThat(ShortestPathBinaryMatrix.shortestPath(new int[][]{{0}}))
                .isEqualTo(1);
    }

    @Test
    void singleCellOne() {
        assertThat(ShortestPathBinaryMatrix.shortestPath(new int[][]{{1}}))
                .isEqualTo(-1);
    }

    @Test
    void startBlocked() {
        int[][] grid = {{1, 0}, {0, 0}};
        assertThat(ShortestPathBinaryMatrix.shortestPath(grid)).isEqualTo(-1);
    }

    @Test
    void endBlocked() {
        int[][] grid = {{0, 0}, {0, 1}};
        assertThat(ShortestPathBinaryMatrix.shortestPath(grid)).isEqualTo(-1);
    }

    @Test
    void noPath() {
        int[][] grid = {{0, 1}, {1, 0}};
        assertThat(ShortestPathBinaryMatrix.shortestPath(grid)).isEqualTo(-1);
    }

    @Test
    void nullGrid() {
        assertThatThrownBy(() -> ShortestPathBinaryMatrix.shortestPath(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void emptyGrid() {
        assertThat(ShortestPathBinaryMatrix.shortestPath(new int[][]{}))
                .isEqualTo(-1);
    }

}