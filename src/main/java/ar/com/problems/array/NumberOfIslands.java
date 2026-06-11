package ar.com.problems.array;

import java.util.*;

/**
 * Given a 2D grid where `'1'` represents land and `'0'` represents water, count the
 * number of islands. An island is a connected component of land cells with
 * 4-directional adjacency (up, down, left, right). Diagonals do **not** count.
 */
public class NumberOfIslands {

    private record Cell(int row, int col) { }

    private static final List<Cell> DIRECTIONS = List.of(
            new Cell(0,1), new Cell(0,-1), new Cell(1,0), new Cell(-1,0)
    );

    public static int numIslands(char[][] grid) {
        Objects.requireNonNull(grid);
        if (grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, rows, cols);
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] grid,
                            int startR,
                            int startC,
                            int rows,
                            int cols) {
        Deque<Cell> queue = new ArrayDeque<>();
        queue.addLast(new Cell(startR, startC));
        grid[startR][startC] = '0';

        while (!queue.isEmpty()) {
            Cell curr  = queue.removeFirst();
            for (Cell direction : DIRECTIONS) {
                int nr = curr.row() + direction.row();
                int nc = curr.col() + direction.col();

                if (nr >= 0 && nr < rows && nc >= 0
                        && nc < cols && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    queue.addLast(new Cell(nr, nc));
                }
            }
        }
    }

}
