package longest_increasing_path_matrix_329;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int height = matrix.length;
        int width = matrix[0].length;

        PriorityQueue<Cell> cells = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                cells.add(new Cell(i, j, matrix[i][j]));

        int[][] paths = new int[height][width];

        for (Cell cell: cells)
            findPaths(cell.i, cell.j, height, width, 1, matrix, paths);

        return findMax(paths, height, width);
    }

    private int findPaths(int i, int j, int height, int width, int currentPath, int[][] matrix, int[][] paths) {
        if (paths[i][j] >= currentPath) return paths[i][j];

        PriorityQueue<Cell> cells = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        if (i + 1 < height && matrix[i+1][j] > matrix[i][j]) cells.add(new Cell(i+1, j, matrix[i][j]));
        if (i - 1 >= 0 && matrix[i-1][j] > matrix[i][j]) cells.add(new Cell(i-1, j, matrix[i][j]));
        if (j + 1 < width && matrix[i][j+1] > matrix[i][j]) cells.add(new Cell(i, j+1, matrix[i][j]));
        if (j - 1 >= 0 && matrix[i][j-1] > matrix[i][j]) cells.add(new Cell(i, j-1, matrix[i][j]));

        int maxLength = currentPath;
        for (Cell cell: cells)
            maxLength = Math.max(maxLength, findPaths(cell.i, cell.j, height, width, currentPath+1, matrix, paths));

        paths[i][j] = maxLength;
        return maxLength;
    }

    private int findMax(int[][] paths, int height, int width) {
        int path = Integer.MIN_VALUE;
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                path = Math.max(paths[i][j], path);

        return path;
    }

    private static class Cell {
        final int i;
        final int j;
        final int val;

        Cell(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}