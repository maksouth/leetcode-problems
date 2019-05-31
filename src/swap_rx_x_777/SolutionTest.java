package swap_rx_x_777;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        String input = "XXXXXLXXXX";
        String target = "LXXXXXXXXX";
        assertTrue(solution.canTransform(input, target));
    }

    @Test
    public void test2() {
        String input = "RXL";
        String target = "XRL";
        assertTrue(solution.canTransform(input, target));
    }

    @Test
    public void test3() {
        String input = "RXL";
        String target = "RLX";
        assertTrue(solution.canTransform(input, target));
    }

    @Test
    public void test4() {
        String input = "X";
        String target = "R";
        assertFalse(solution.canTransform(input, target));
    }

    @Test
    public void test5() {
        String input = "RXXLRXRXL";
        String target = "XRLXXRRLX";
        assertTrue(solution.canTransform(input, target));
    }
}