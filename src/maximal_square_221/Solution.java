package maximal_square_221;

class Solution {
    public int maximalSquare(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] -= '0';
                if (i > 0 && j > 0 && matrix[i][j] == 1)
                    matrix[i][j] += Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]);
            }

        int max = Integer.MIN_VALUE;
        for (char[] row: matrix)
            for (char cell: row)
                max = Math.max(max, cell);

        return max;
    }
}