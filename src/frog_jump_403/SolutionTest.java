package frog_jump_403;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        int[] stones = {0,1,3,4,5,7,9,10,12};
        assertTrue(solution.canCross(stones));
    }

}