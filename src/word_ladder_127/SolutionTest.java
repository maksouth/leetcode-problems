package word_ladder_127;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test1() {
        String start = "hit";
        String end = "cog";
        List<String> dict = Arrays.asList("hot","dot","dog","lot","log","cog");

        assertEquals(5, solution.ladderLength(start, end, dict));
    }

    @Test
    public void test2() {
        String start = "hot";
        String end = "dog";
        List<String> dict = Arrays.asList("hot","dog","dot");

        assertEquals(3, solution.ladderLength(start, end, dict));
    }
}