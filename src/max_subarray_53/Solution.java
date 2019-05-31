package max_subarray_53;

class Solution {
    public int maxSubArray(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);

        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) maxSum = Math.max(maxSum, num);

        return maxSum;
    }
}