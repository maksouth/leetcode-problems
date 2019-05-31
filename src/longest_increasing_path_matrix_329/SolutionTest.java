package longest_increasing_path_matrix_329;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        int[][] nums = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        assertEquals(4, solution.longestIncreasingPath(nums));
    }
}