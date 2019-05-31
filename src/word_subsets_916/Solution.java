package word_subsets_916;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] targetSymbols = new int[26];

        for (String b: B) {
            int[] symbols = count(b);
            for (int i = 0; i < symbols.length; i++)
                targetSymbols[i] = Math.max(targetSymbols[i], symbols[i]);
        }

        List<String> result = new ArrayList<>();
        for (String a: A)
            if (isSubset(count(a), targetSymbols))
                result.add(a);

        return result;
    }

    private int[] count(String input) {
        int[] res = new int[26];
        for (char c: input.toCharArray())
            res[c - 'a']++;
        return res;
    }

    private boolean isSubset(int[] symbols, int[] targetSymbols) {
        for (int i = 0; i < symbols.length; i++)
            if (symbols[i] < targetSymbols[i]) return false;
        return true;
    }
}