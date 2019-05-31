package same_tree_100;

import java.util.Objects;
import java.util.Stack;

import static binary_tree_traversal_102.Solution.TreeNode;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();

        first.add(p);
        second.add(q);

        TreeNode firstCurrent;
        TreeNode secondCurrent;
        while (!first.isEmpty() && !second.isEmpty()) {
            firstCurrent = first.pop();
            secondCurrent = second.pop();

            if (firstCurrent == null && secondCurrent == null)
                continue;

            if (firstCurrent == null
                    || secondCurrent == null
                    || firstCurrent.val != secondCurrent.val)
                return false;

            first.push(firstCurrent.left);
            first.push(firstCurrent.right);

            second.push(secondCurrent.left);
            second.push(secondCurrent.right);
        }

        return true;
    }
}