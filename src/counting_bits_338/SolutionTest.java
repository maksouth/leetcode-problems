package counting_bits_338;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test0() {
        assertArrayEquals(new int[]{0}, solution.countBits(0));
    }

    @Test
    public void test13() {
        assertArrayEquals(new int[]{0,1,1,2,1,2,2,3,1,2,2,3,2,3}, solution.countBits(13));
    }
}