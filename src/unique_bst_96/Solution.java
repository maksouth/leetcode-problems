package unique_bst_96;

class Solution {
    public int numTrees(int n) {
        int[] mem = new int[n+1];
        for (int i = 0; i <= n; i++)
            mem[i] = -1;

        return calculateNumTrees(n, mem);
    }

    private int calculateNumTrees(int num, int[] memoization) {
        if (num < 2)
            return 1;
        if (num == 2)
            return 2;

        if (memoization[num] != -1)
            return memoization[num];

        int result = 0;

        for (int i = 0; i < num; i++) {
            int leftNum = calculateNumTrees(i, memoization);
            int rightNum = calculateNumTrees(num - i - 1, memoization);
            result += leftNum * rightNum;
        }

        memoization[num] = result;
        return result;
    }
}