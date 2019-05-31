package next_permutation;

class Solution {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        for (int i = nums.length - 1; i > 0; i--)
            if (nums[i] > nums[i-1]) {
                swap(nums, index, i-1);
                return;
            } else if(nums[i] < nums[index])
                index = i;

        for (int i = 0; i < nums.length / 2; i++)
            swap(nums, i, nums.length - i - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}