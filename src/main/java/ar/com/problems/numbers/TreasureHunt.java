package ar.com.problems.numbers;

public class TreasureHunt {

    public static int findTreasureHunt(int[][] grid, int starRow, int starCol) {

        int row =  starRow -1;
        int col =  starCol -1;
        int lengthGrid = grid.length;
        int steps = 0;

        while (steps < (lengthGrid * lengthGrid)) {
            int currentValue = grid[row][col];

            if (currentValue == (row + 1) * 10 + (col + 1) ) {
                return currentValue;
            }

            int nextRow = (currentValue / 10) - 1;
            int nextCol = (currentValue % 10) - 1;

            row = nextRow;
            col = nextCol;

            steps++;
        }

        return 0;
    }

}
