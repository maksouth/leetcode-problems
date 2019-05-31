package stone_game_877;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        int[] values = {5,3,4,5};
        System.out.println(solution.stoneGame(values));
    }
}