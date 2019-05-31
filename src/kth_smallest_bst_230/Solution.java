package kth_smallest_bst_230;

import static binary_tree_traversal_102.Solution.TreeNode;

import java.util.LinkedList;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (--k == 0) return root.val;
            root = root.right;
        }

        return -1;
    }
}