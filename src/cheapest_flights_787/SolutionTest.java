package cheapest_flights_787;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void test1() {
        Solution solution = new Solution();

        int[][] edges = {
                {0, 1, 10},
                {0, 2, 15},
                {2, 5, 10},
                {1, 3, 6},
                {1, 4, 15},
                {3, 4, 2},
                {4, 5, 1},
                {3, 5, 5}
        };
        int start = 0;
        int end = 5;
        int k = 10;

        solution.findCheapestPrice(6, edges, start, end, k);
    }

}