package rotate_image_48;

class Solution {
    public void rotate(int[][] matrix) {
        for(int level = 0; level < matrix.length / 2; level++) {
            int n = matrix.length - level - 1;
            for (int i = n; i > level; i--) {
                swap(matrix, i, n, level, i);
                swap(matrix, level, i, level + n - i, level);
                swap(matrix, level + n - i, level, n, level + n - i);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}