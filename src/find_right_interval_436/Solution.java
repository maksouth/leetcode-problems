package find_right_interval_436;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
        int[] rights = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int index = binarySearchCeiling(intervals, i);
            rights[i] = index;
        }

        return rights;
    }

    private int binarySearchCeiling(Interval[] intervals, int index) {
        int ceiling = 0;

        for (int i = 0; i < intervals.length; i++)
            if (intervals[i].start >= intervals[index].end
                    && intervals[ceiling].start > intervals[i].start
                    && i != index)
                ceiling = i;

        if (intervals[ceiling].start > intervals[index].end) return ceiling;
        else return -1;
    }
}

class Interval {
    public int start;
    public int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}