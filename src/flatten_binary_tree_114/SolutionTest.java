package flatten_binary_tree_114;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        TreeNode head = node(1);

        head.left = node(2);
        head.right = node(5);
        head.left.left = node(3);
        head.left.right = node(4);
        head.right.right = node(6);

        solution.flatten(head);
    }

    @Test
    public void test2() {
        TreeNode head = node(0);
        solution.flatten(head);
    }

    private TreeNode node(int val) {
        return new TreeNode(val);
    }

}