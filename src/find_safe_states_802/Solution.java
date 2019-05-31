package find_safe_states_802;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++)
            isInCycle(i, graph, visited);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++)
            if (visited[i] == 2)
                result.add(i);

        return result;
    }

    private boolean isInCycle(int current, int[][] graph, int[] visited) {
        if (visited[current] == 1) return true;
        if (visited[current] == 2) return false;

        boolean cycle = false;
        visited[current] = 1;
        for (int next: graph[current])
            cycle |= isInCycle(next, graph, visited);

        if (!cycle) visited[current] = 2;
        return cycle;
    }
}