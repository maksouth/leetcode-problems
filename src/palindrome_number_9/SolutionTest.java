package palindrome_number_9;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        assertTrue(solution.isPalindrome(121));
    }

    @Test
    public void test2() {
        assertFalse(solution.isPalindrome(12));
    }

    @Test
    public void test3() {
        assertTrue(solution.isPalindrome(1000000001));
    }

    @Test
    public void test4() {
        assertFalse(solution.isPalindrome(1002021));
    }

}