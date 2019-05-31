package city_scheduling_1029;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingDouble(o -> o[0] - o[1]));
        int sum = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            int j = costs.length / 2 + i;
            sum += costs[i][0];
            sum += costs[j][1];
        }

        return sum;
    }
}