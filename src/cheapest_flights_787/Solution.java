package cheapest_flights_787;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight: flights) {
            if(!graph.containsKey(flight[0])) graph.put(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        q.add(new int[]{0, src, K+1});

        while (!q.isEmpty()) {
            int[] flight = q.poll();
            int price = flight[0], current = flight[1], stops = flight[2];
            if (current == dst) return price;

            if (stops > 0) {
                Map<Integer, Integer> neighbours = graph.getOrDefault(current, new HashMap<>());
                for (Integer next: neighbours.keySet())
                    q.add(new int[]{price + neighbours.get(next), next, stops-1});
            }
        }

        return -1;
    }
}