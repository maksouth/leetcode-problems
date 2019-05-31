package binary_tree_inorder_traversal_94;

import static binary_tree_traversal_102.Solution.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }

            root = stack.removeFirst();
            traversal.add(root.val);
            root = root.right;
        }

        return traversal;
    }
}