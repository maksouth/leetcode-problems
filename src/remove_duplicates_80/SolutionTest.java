package remove_duplicates_80;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        int[] array = {1,1,2};
        int uniques = solution.removeDuplicates(array);
        int[] expected = {1, 1, 2};

        assertEquals(3, uniques);

        for (int i = 0; i < uniques; i++)
            assertEquals(expected[i], array[i]);
    }

    @Test
    public void test2() {
        int[] array = {1,1,1,2,2,3};
        int uniques = solution.removeDuplicates(array);
        int[] expected = {1, 1, 2,2,3};

        assertEquals(5, uniques);

        for (int i = 0; i < uniques; i++)
            assertEquals(expected[i], array[i]);
    }

    @Test
    public void test3() {
        int[] array = {0,0,1,1,1,1,2,3,3};
        int uniques = solution.removeDuplicates(array);
        int[] expected = {0, 0, 1, 1, 2, 3,3};

        assertEquals(7, uniques);

        for (int i = 0; i < uniques; i++)
            assertEquals(expected[i], array[i]);
    }
}