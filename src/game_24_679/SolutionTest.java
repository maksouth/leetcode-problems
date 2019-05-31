package game_24_679;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        solution.judgePoint24(new int[]{1, 2, 3, 4});
    }

    @Test
    public void test2() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> priorities = Arrays.asList(1, 0, 2);
        List<Integer> operations = Arrays.asList(2, 0, 2);
        assertEquals(20, solution.calculate(nums, priorities, operations));
    }

    @Test
    public void test3() {
        List<Integer> nums = Arrays.asList(8,4,7,1);
        List<Integer> priorities = Arrays.asList(0, 2, 1);
        List<Integer> operations = Arrays.asList(1, 2, 1);
        assertEquals(24, solution.calculate(nums, priorities, operations));
    }
}