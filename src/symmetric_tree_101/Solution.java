package symmetric_tree_101;

import static binary_tree_traversal_102.Solution.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val)
            return false;

        return compare(left.left, right.right)
                && compare(left.right, right.left);
    }
}