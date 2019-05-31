package find_duplicate_287;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void test1() {
        int[] values = {1,3,4,2,2};
        System.out.println(solution.findDuplicate(values));
    }

    @Test
    public void test2() {
        int[] values = {3,1,3,4,2};
        System.out.println(solution.findDuplicate(values));
    }

    @Test
    public void test3() {
        int[] values = {2,5,9,6,9,3,8,9,7,1};
        System.out.println(solution.findDuplicate(values));
    }
}