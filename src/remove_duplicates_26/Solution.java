package remove_duplicates_26;

class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] != nums[i-1])
                nums[unique++] = nums[i];

        return unique;
    }
}
