package letter_case_permutation_784;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        String string = "aaaaaaaaaaaa";
        System.out.println(solution.letterCasePermutation(string));
    }

    @Test
    public void test2() {
        String string = "a1b2";
        System.out.println(solution.letterCasePermutation(string));
    }
}