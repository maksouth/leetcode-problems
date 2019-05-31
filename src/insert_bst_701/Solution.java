package insert_bst_701;

import static binary_tree_traversal_102.Solution.TreeNode;

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val < val) {
            if (root.right == null) root.right = new TreeNode(val);
            else insertIntoBST(root.right, val);
        } else {
            if (root.left == null) root.left = new TreeNode(val);
            else insertIntoBST(root.left, val);
        }

        return root;
    }
}