package parse_lisp_expression_736;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testNumber() {
        Assert.assertEquals(2, solution.evaluate("2"));
    }

    @Test
    public void testSum() {
        Assert.assertEquals(5, solution.evaluate("(add 2 3)"));
    }

    @Test
    public void testMult() {
        Assert.assertEquals(6, solution.evaluate("(mult 2 3)"));
    }

    @Test
    public void testMultThenAdd() {
        Assert.assertEquals(10, solution.evaluate("(add 4 (mult 2 3))"));
    }

    @Test
    public void testLet() {
        Assert.assertEquals(4, solution.evaluate("(let x 4 x)"));
    }

    @Test
    public void testSequenceLet() {
        Assert.assertEquals(3, solution.evaluate("(let x 4 x 3 x)"));
    }

    @Test
    public void testScopeLet() {
        Assert.assertEquals(3, solution.evaluate("(let x 4 (let x 3 x))"));
    }

    @Test
    public void test1() {
        Assert.assertEquals(6, solution.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, solution.evaluate("(let a1 3 b2 (add a1 1) b2)"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(5, solution.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(-12, solution.evaluate("(let x 7 -12)"));
    }
}