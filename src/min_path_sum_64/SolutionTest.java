package min_path_sum_64;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        int[][] matrix = {
          {1,3,1},
          {1,5,1},
          {4,2,1}
        };

        assertEquals(7, solution.minPathSum(matrix));
    }

}