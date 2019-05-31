package word_ladder_127;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int index = wordList.indexOf(endWord);
        if (index == -1) return 0;

        wordList = new ArrayList<>(wordList);
        wordList.add(beginWord);

        List<Set<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++)
            edges.add(new HashSet<>());

        for(int i = 0; i  < wordList.size(); i++)
            for (int j = i + 1; j < wordList.size(); j++)
                if (symbolsDiffer(wordList.get(i), wordList.get(j)) <= 1) {
                    edges.get(i).add(j);
                    edges.get(j).add(i);
                }

        return bfs(edges, wordList.size() - 1, index);
    }

    private int symbolsDiffer(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count > 1) return count;
        }
        return count;
    }

    private int bfs(List<Set<Integer>> edges, int startNode, int end) {
        int[] paths = new int[edges.size()];

        Queue<Integer> nodes = new LinkedList<>();

        paths[startNode] = 1;
        nodes.add(startNode);

        while (!nodes.isEmpty()) {
            int current = nodes.remove();
            if (current == end) return paths[end];

            for (Integer node: edges.get(current))
                if (paths[node] == 0) {
                    paths[node] = paths[current] + 1;
                    nodes.add(node);
                }
        }

        return paths[end];
    }
}