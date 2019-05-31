package unique_bst_96;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        assertEquals(1, solution.numTrees(1));
    }

    @Test
    public void test2() {
        assertEquals(2, solution.numTrees(2));
    }


    @Test
    public void test3() {
        assertEquals(5, solution.numTrees(3));
    }


    @Test
    public void test4() {
        assertEquals(14, solution.numTrees(4));
    }


    @Test
    public void test5() {
        assertEquals(42, solution.numTrees(5));
    }


    @Test
    public void test6() {
        assertEquals(16796, solution.numTrees(10));
    }
}