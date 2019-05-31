package binary_tree_right_view_199;

import java.util.ArrayList;
import java.util.List;

import static binary_tree_traversal_102.Solution.TreeNode;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }

    private void traverse(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;

        if (level >= result.size()) result.add(root.val);

        traverse(root.right, level+1, result);
        traverse(root.left, level+1, result);
    }
}