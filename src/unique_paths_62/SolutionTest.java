package unique_paths_62;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        assertEquals(28, solution.uniquePaths(7, 3));
    }

    @Test
    public void test2() {
        assertEquals(3, solution.uniquePaths(3, 2));
    }

}