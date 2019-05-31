package remove_duplicates_26;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void test1() {
        int[] array = {1,1,2};
        int uniques = solution.removeDuplicates(array);
        int[] expected = {1,2};

        assertEquals(2, uniques);

        for (int i = 0; i < uniques; i++)
            assertEquals(expected[i], array[i]);
    }

    @Test
    public void test2() {
        int[] array = {0,0,1,1,1,2,2,3,3,4};
        int uniques = solution.removeDuplicates(array);
        int[] expected = {0,1,2,3,4};

        assertEquals(5, uniques);

        for (int i = 0; i < uniques; i++)
            assertEquals(expected[i], array[i]);
    }
}