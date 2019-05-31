package range_sum_query_mutable_307;

import java.util.Arrays;

class NumArray {

    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n * 2];
        buildTree(nums);
    }

    private void buildTree(int[] nums) {
        for (int i = 0, j = n; i < n; i++, j++)
            tree[j] = nums[i];

        for (int i = n -1; i > 0; i--)
            tree[i] = tree[2 * i] + tree[2 * i + 1];
    }

    public void update(int i, int val) {
        tree[n + i] = val;
        int index = (n + i) / 2;

        do {
            tree[index] = tree[2 * index] + tree[2 * index + 1];
            index /= 2;
        } while (index != 0);
    }

    public int sumRange(int i, int j) {
        int l = i + n;
        int r = j + n;
        int sum = 0;

        while (l <= n) {
            if (l % 2 == 1) {
                sum += tree[l];
                l++;
            }

            if (r % 2 == 0) {
                sum += tree[r];
                r--;
            }

            l /= 2;
            r /= 2;
        }

        return sum;
    }
}