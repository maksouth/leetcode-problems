package climbing_stairs_70;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        assertEquals(21, solution.climbStairs(7));
    }

    @Test
    public void test2() {
        assertEquals(2, solution.climbStairs(2));
    }

    @Test
    public void test3() {
        assertEquals(1, solution.climbStairs(1));
    }

    @Test
    public void test4() {
        assertEquals(8, solution.climbStairs(5));
    }
}