package ar.com.problems.numbers;

import java.util.*;

/**
 * Shortest Path in Binary Matrix
 * Given an n x n binary matrix grid where 0 is empty and 1 is obstacle,
 * find the shortest path from top-left (0,0) to bottom-right (n-1,n-1).
 * Return the length (including start and end) or -1 if impossible.
 */
public class ShortestPathBinaryMatrix {

    private record Cell (int row, int col) {}

    private static final List<Cell> DIRECTIONS = List.of(
            new Cell(0, 1), new Cell(0, -1),
            new Cell(1,0), new Cell(-1,0)
    );

    public static int shortestPath(int[][] grid) {
        Objects.requireNonNull(grid);
        int n = grid.length;
        if (n == 0) return -1;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);

        Deque<Cell> queue = new ArrayDeque<>();
        dist[0][0] = 1;
        queue.addLast(new Cell(0, 0));

        while (!queue.isEmpty()) {
            Cell c = queue.removeFirst();
            if (c.row == n - 1 && c.col == n - 1) {
                return  dist[c.row][c.col];
            }
            for (Cell d : DIRECTIONS) {
                int nr = c.row + d.row;
                int nc = c.col + d.col;

                if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && dist[nr][nc] == 0 && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[c.row][c.col] + 1;
                    queue.addLast(new Cell(nr, nc));
                }
            }
        }

        return -1;
    }

}
