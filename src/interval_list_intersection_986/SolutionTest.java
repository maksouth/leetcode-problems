package interval_list_intersection_986;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        int[][] a = {{3,5},{9,20}};
        int[][] b = {{4,5},{7,10},{11,12},{14,15},{16,20}};
        int[][] c = solution.intervalIntersection(a, b);

    }

}