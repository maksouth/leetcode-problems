package game_24_679;

import java.util.*;

class Solution {

    public boolean judgePoint24(int[] nums) {

        List<List<Integer>> numberPermutations = numberPermutations(nums);
        List<List<Integer>> operationPriorities = operationPrioritiesPermutations();
        List<List<Integer>> operationTypeCombinations = operationTypeCombinations();

        for (List<Integer> numbers: numberPermutations)
            for (List<Integer> operationPriority: operationPriorities)
                for (List<Integer> operationTypes: operationTypeCombinations)
                    try {
                        if (calculate(numbers, operationPriority, operationTypes) == 24)
                            return true;
                    } catch (Exception e) {}

        return false;
    }

    int calculate(List<Integer> numbers, List<Integer> operationPriority, List<Integer> operationTypes) {
        int firstOperation = operationPriority.indexOf(0);
        int result = calculate(
                numbers.get(firstOperation),
                numbers.get(firstOperation+1),
                operationTypes.get(firstOperation));

        numbers.set(firstOperation, result);
        numbers.set(firstOperation + 1, result);

        int secondOperation = operationPriority.indexOf(1);
        result = calculate(
                numbers.get(secondOperation),
                numbers.get(secondOperation+1),
                operationTypes.get(secondOperation));

        numbers.set(secondOperation, result);
        numbers.set(secondOperation + 1, result);
        if (Math.abs(secondOperation - firstOperation) == 1) {
            numbers.set(firstOperation + 1, result);
            numbers.set(firstOperation, result);
        }

        int thirdOperation = operationPriority.indexOf(2);
        result = calculate(
                numbers.get(thirdOperation),
                numbers.get(thirdOperation+1),
                operationTypes.get(thirdOperation));

        return result;
    }

    private int calculate(Integer first, Integer second, Integer type) {
        if (type == 0)
            return first + second;
        if (type == 1)
            return first - second;
        if (type == 2)
            return first * second;
        if (type == 3)
            return first / second;
        return 0;
    }

    private List<List<Integer>> operationTypeCombinations() {
        Set<Integer> set = setOf(3);
        List<List<Integer>> result = new ArrayList<>();
        combinations(new ArrayList<>(), set, result);
        return result;
    }

    private void combinations(List<Integer> prefix, Set<Integer> suffix, List<List<Integer>> result) {
        if (prefix.size() == suffix.size()) {
            result.add(new ArrayList<>(prefix));
            return;
        }

        for (int num: suffix) {
            prefix.add(num);
            combinations(prefix, suffix, result);
            prefix.remove((Integer) num);
        }
    }

    private List<List<Integer>> operationPrioritiesPermutations() {
        return permutations(setOf(3));
    }

    private List<List<Integer>> numberPermutations(int[] nums) {
        return permutations(from(nums));
    }

    private List<List<Integer>> permutations(Set<Integer> seed) {
        List<Integer> prefix = new ArrayList<>();

        List<List<Integer>> numberPermutations = new ArrayList<>();
        permutations(prefix, seed, numberPermutations);

        return numberPermutations;
    }

    private Set<Integer> from(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        return set;
    }

    private void permutations(List<Integer> prefix, Set<Integer> suffix, List<List<Integer>> result) {
        if (suffix.size() == 0) {
            result.add(prefix);
            return;
        }

        for (int num: suffix) {
            Set<Integer> newSuffix = new HashSet<>(suffix);
            newSuffix.remove(num);

            List<Integer> newPrefix = new ArrayList<>(prefix);
            newPrefix.add(num);

            permutations(newPrefix, newSuffix, result);
        }
    }

    private Set<Integer> setOf(int size) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) set.add(i);
        return set;
    }
}