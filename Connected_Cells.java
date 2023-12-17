package BTtuan12;

import java.util.List;

public class Connected_Cells {
    public static int visitCell(List<List<Integer>> matrix, boolean[][] visited, int row, int col) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || matrix.get(row).get(col) == 0) {
            return 0;
        }

        visited[row][col] = true;
        int size = 1;


        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                size += visitCell(matrix, visited, i, j);
            }
        }

        return size;
    }
    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        int maxRegion = 0;
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix.get(i).get(j) == 1 && !visited[i][j]) {
                    int regionSize = visitCell(matrix, visited, i, j);
                    maxRegion = Math.max(maxRegion, regionSize);
                }
            }
        }
        return maxRegion;
    }

}
