package remove_duplicates_80;

class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 1;
        boolean duplicate = true;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == nums[i-1] && duplicate) {
                nums[unique++] = nums[i];
                duplicate = false;
            } else if (nums[i] != nums[i-1]) {
                nums[unique++] = nums[i];
                duplicate = true;
            }

        return unique;
    }
}