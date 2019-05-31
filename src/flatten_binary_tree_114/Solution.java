package flatten_binary_tree_114;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public void flatten(TreeNode root) {
        TreeNode tree = root;
        Deque<TreeNode> stack = new LinkedList<>();

        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            if (node != null) {
                stack.addFirst(node.right);
                stack.addFirst(node.left);

                tree.right = node;
                tree.left = null;
                tree = tree.right;
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}