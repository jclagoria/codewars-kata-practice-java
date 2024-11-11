package ar.com.problems.array;

public class NightmareEscape {

    public static int findSafestPath(int[][] dream) {

        int rows = dream.length;
        int cols = dream[0].length;

        int[][] dangerLevel = new int[rows][cols];

        dangerLevel[0][0] = dream[0][0];

        // Llenar la primera fila
        for (int j = 1; j < cols; j++) {
            dangerLevel[0][j] = dangerLevel[0][j - 1] + dream[0][j];
        }

        //Llenar la primea columna
        for (int i = 1; i < rows; i++) {
            dangerLevel[i][0] = dangerLevel[i - 1][0] + dream[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dangerLevel[i][j] = dream[i][j]
                        + Math.min(dangerLevel[i - 1][j], dangerLevel[i][j - 1]);
            }
        }

        return dangerLevel[rows - 1][cols - 1];
    }
}
