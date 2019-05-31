package is_subsequence_392;

class Solution {
    public boolean isSubsequence(String subsequence, String original) {
        if (subsequence.length() == 0) return true;
        int curr = 0;
        for (char c: original.toCharArray()) {
            if (subsequence.charAt(curr) == c) curr++;
            if (curr == subsequence.length()) return true;
        }

        return false;
    }
}