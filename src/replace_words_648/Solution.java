package replace_words_648;

import java.util.Comparator;
import java.util.List;

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        if (sentence.length() == 0) return "";

        dict.sort(Comparator.comparingInt(String::length));

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word: words) {
            for(String root: dict)
                if (word.startsWith(root)) {
                    word = root;
                    break;
                }
            result.append(word).append(" ");
        }

        return result.substring(0, result.length() - 1);
    }
}