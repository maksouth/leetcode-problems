package sliding_window_max_239;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        PriorityQueue<Integer> window = new PriorityQueue<>(Comparator.reverseOrder());

        int[] windowsMax = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            window.add(nums[i]);

            if (window.size() > k)
                window.remove(nums[i - k]);

            if (i + 1 >= k)
                windowsMax[i - k + 1] = window.peek();
        }

        return windowsMax;
    }
}