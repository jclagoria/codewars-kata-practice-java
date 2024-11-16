package ar.com.problems.array;

import java.util.LinkedList;
import java.util.Queue;

public class SilentHillEscape {

    static class Position {
        int row, col, steps;

        public Position(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public static int escapeFromPyramidHead(char[][] room) {
        int n = room.length;
        Position playerPos = null;
        Position pyramidHeadPos = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (room[i][j] == 'T') {
                    playerPos = new Position(i,j,0);
                }
                if (room[i][j] == '▲') {
                    pyramidHeadPos = new Position(i,j,0);
                }
            }
        }

        if(playerPos == null || pyramidHeadPos == null) {
            return -1;
        }

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        boolean[][] visited = new boolean[n][n];

        Queue<Position> queue = new LinkedList<>();
        queue.add(pyramidHeadPos);
        visited[pyramidHeadPos.row][pyramidHeadPos.col] = true;

        while (!queue.isEmpty()) {
            Position currentPost = queue.poll();

            if (currentPost.row == playerPos.row
                    && currentPost.col == playerPos.col) {
                return currentPost.steps;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = currentPost.row + dRow[i];
                int newCol = currentPost.col + dCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n
                        && room[newRow][newCol] != '#' && !visited[newRow][newCol]) {
                    queue.add(new Position(newRow,newCol,currentPost.steps + 1));
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }

}
