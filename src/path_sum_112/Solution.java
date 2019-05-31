package path_sum_112;

import static binary_tree_traversal_102.Solution.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, 0, sum);
    }

    private boolean hasPathSum(TreeNode root, int current, int target) {
        if (root == null) return false;

        current += root.val;

        if (root.left == null && root.right == null)
            return current == target;
        return hasPathSum(root.left, current, target)
                || hasPathSum(root.right, current, target);
    }
}