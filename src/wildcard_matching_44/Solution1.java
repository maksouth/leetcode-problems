package wildcard_matching_44;

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    Map<String, Boolean> memo;
    public boolean isMatch(String s, String p) {
        char[] regex = p.toCharArray();
        char[] text = s.toCharArray();
        memo = new HashMap<>();
        return match(0, regex, 0, text);
    }

    private boolean match(int i, char[] regex, int j, char[] text) {
        if (memo.containsKey(i + "#" + j))
            return memo.containsKey(i + "#" + j);
        boolean result = false;
        if (i < regex.length - 1 && regex[i] == '*' && regex[i+1] == '*') result = match(i+1, regex, j, text);
        else if (j == text.length && (i < regex.length && regex[i] == '*')) result = match(i+1, regex, j, text);
        else if ((i == regex.length) != (j == text.length)) result = false;
        else if (i == regex.length && j == text.length) result = true;
        else if (regex[i] == '?') result = match(i+1, regex, j+1, text);
        else if (regex[i] == '*') result = match(i+1, regex, j, text)
                || match(i+1, regex, j+1, text)
                || match(i, regex, j+1, text);
        else if (regex[i] == text[j]) result = match(i+1, regex, j+1, text);

        memo.put(i + "#" + j, result);
        return result;
    }
}