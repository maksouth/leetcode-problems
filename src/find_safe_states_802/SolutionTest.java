package find_safe_states_802;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test1() {
        int[][] graph = {{1,2},{2,3},{5},{0,6},{5},{},{}};
        solution.eventualSafeNodes(graph);
    }
}