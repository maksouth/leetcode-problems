package sum_root_leaf_numbers_129;

class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int path) {
        if (root == null) return 0;

        path = 10 * path + root.val;

        if (root.left == null && root.right == null)
            return path;
        else return sum(root.left, path) + sum(root.right, path);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}