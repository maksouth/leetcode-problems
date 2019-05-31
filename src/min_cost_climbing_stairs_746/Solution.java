package min_cost_climbing_stairs_746;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return 0;

        for (int i = cost.length - 2; i >= 0; i--)
            cost[i] = cost[i] + Math.min(cost[i+1], cost[i+2]);

        return Math.min(cost[0], cost[1]);
    }
}