package minimum_area_rectangle_939;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        int[][] points = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        System.out.println(solution.minAreaRect(points));
    }
}