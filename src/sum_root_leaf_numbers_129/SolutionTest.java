package sum_root_leaf_numbers_129;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = node(2);
        root.right = node(3);
        System.out.println(solution.sumNumbers(root));
    }

    private TreeNode node(int val) {
        return new TreeNode(val);
    }
}