package min_path_sum_64;

import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];

        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++)
            dp[i] = grid[0][i] + dp[i-1];

        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++)
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);
        }

        return dp[grid[0].length - 1];
    }
}