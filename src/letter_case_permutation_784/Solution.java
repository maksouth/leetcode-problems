package letter_case_permutation_784;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String input) {
        List<String> result = new ArrayList<>();
        permutate(input.toCharArray(), 0, result);
        return result;
    }

    private void permutate(char[] input, int index, List<String> result) {
        if (index >= input.length) {
            result.add(new String(input));
            return;
        }

        permutate(input, index + 1, result);
        if (Character.isUpperCase(input[index])) {
            input[index] = Character.toLowerCase(input[index]);
            permutate(input, index + 1, result);
        } else if (Character.isLowerCase(input[index])) {
            input[index] = Character.toUpperCase(input[index]);
            permutate(input, index + 1, result);
        }
    }
}