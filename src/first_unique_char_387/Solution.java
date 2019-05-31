package first_unique_char_387;

import java.util.Arrays;

class Solution {
    public int firstUniqChar(String s) {
        int[] chars = new int[26];

        Arrays.fill(chars, -1);

        int minIndex = Integer.MAX_VALUE;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (chars[c] == -1) chars[c] = i;
            else chars[c] = -1;
        }

        for (int position: chars)
            minIndex = Math.min(minIndex, position);

        if (minIndex == Integer.MAX_VALUE) minIndex = -1;
        return minIndex;
    }
}