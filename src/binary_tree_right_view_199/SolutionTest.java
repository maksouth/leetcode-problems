package binary_tree_right_view_199;

import static binary_tree_traversal_102.Solution.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(6);

        node.right = new TreeNode(3);
        node.right.right = new TreeNode(4);

        solution.rightSideView(node);
    }

}