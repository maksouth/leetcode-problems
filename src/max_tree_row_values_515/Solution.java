package max_tree_row_values_515;

import static binary_tree_traversal_102.Solution.TreeNode;

import java.util.*;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        List<Integer> maxValues = new ArrayList<>();

        if (root != null) nodes.offer(root);

        TreeNode node;
        int max;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                node = nodes.remove();

                max = Math.max(max, node.val);
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
            }

            maxValues.add(max);
        }

        return maxValues;
    }
}