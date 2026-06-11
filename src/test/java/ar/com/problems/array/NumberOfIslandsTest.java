package ar.com.problems.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NumberOfIslandsTest {
    @Test
    void exampleCase() {
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '1', '0', '1'},
                {'0', '0', '0', '1'}
        };
        assertThat(NumberOfIslands.numIslands(grid)).isEqualTo(2);
    }

    @Test
    void emptyGrid() {
        assertThat(NumberOfIslands.numIslands(new char[][]{})).isZero();
    }

    @Test
    void nullGrid() {
        assertThatThrownBy(() -> NumberOfIslands.numIslands(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void allWater() {
        char[][] grid = {{'0', '0'}, {'0', '0'}};
        assertThat(NumberOfIslands.numIslands(grid)).isZero();
    }

    @Test
    void allLand() {
        char[][] grid = {{'1', '1'}, {'1', '1'}};
        assertThat(NumberOfIslands.numIslands(grid)).isOne();
    }

    @Test
    void diagonalNotConnected() {
        char[][] grid = {{'1', '0'}, {'0', '1'}};
        assertThat(NumberOfIslands.numIslands(grid)).isEqualTo(2);
    }

    @Test
    void singleRow() {
        char[][] grid = {{'1', '0', '1', '0', '1'}};
        assertThat(NumberOfIslands.numIslands(grid)).isEqualTo(3);
    }

    @Test
    void singleColumn() {
        char[][] grid = {{'1'}, {'0'}, {'1'}, {'1'}};
        assertThat(NumberOfIslands.numIslands(grid)).isEqualTo(2);
    }
}