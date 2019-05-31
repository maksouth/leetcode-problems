package wildcard_matching_44;

class Solution {
    public boolean isMatch(String string, String pattern) {
        char[] regex = pattern.toCharArray();
        char[] text = string.toCharArray();
        int p = 0;
        int s = 0;

        int starIdx = -1;
        int match = 0;

        while (s < text.length) {
            if (regex[p] == '?' || regex[p] == text[s]) {
                p++;
                s++;
            } else if (p < regex.length && regex[p] == '*') {
                match = s;
                starIdx = p;
                p++;
            } else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            } else return false;
        }

        while (p < pattern.length() && regex[p] == '*') p++;

        return p == regex.length && s == text.length;
    }
}