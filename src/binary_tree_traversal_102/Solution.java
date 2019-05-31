package binary_tree_traversal_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Pair> queue = new LinkedList<>();

        queue.addLast(new Pair(0, root));

        Pair pair;
        while (!queue.isEmpty()) {
            pair = queue.removeFirst();
            if (pair.node == null) continue;

            if (result.size() <= pair.level) result.add(new ArrayList<>());
            result.get(pair.level).add(pair.node.val);

            queue.addLast(new Pair(pair.level+1, pair.node.left));
            queue.addLast(new Pair(pair.level+1, pair.node.right));
        }

        return result;
    }

    private static class Pair {
        final int level;
        final TreeNode node;

        private Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }
}
