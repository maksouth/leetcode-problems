package permutations_46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> numsList = toList(nums);
        List<Integer> preffix = Collections.emptyList();

        permutate(preffix, numsList, results);
        return results;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num: nums) list.add(num);
        return list;
    }

    private void permutate(List<Integer> prefix, List<Integer> suffix, List<List<Integer>> results) {
        if (suffix.isEmpty())
            results.add(prefix);
        List<Integer> newSuffix;
        List<Integer> newPrefix;
        for (int i = 0; i < suffix.size(); i++) {
            newSuffix = new ArrayList<>(suffix);
            int deleted = newSuffix.remove(i);
            newPrefix = new ArrayList<>(prefix);
            newPrefix.add(deleted);
            permutate(newPrefix, newSuffix, results);
        }
    }
}