package minimum_area_rectangle_939;

import java.util.*;

class Solution {
    public int minAreaRect(int[][] points) {
        TreeMap<Integer, List<Integer>> xToYs = new TreeMap<>();

        for (int[] point: points) {
            int x = point[0];
            int y = point[1];
            if (!xToYs.containsKey(x))
                xToYs.put(x, new ArrayList<>());
            xToYs.get(x).add(y);
        }

        HashMap<Integer, Integer> edgeToX = new HashMap<>();
        int minSquare = Integer.MAX_VALUE;
        for (int x: xToYs.keySet()) {
            List<Integer> line = xToYs.get(x);
            Collections.sort(line);

            for (int i = 0; i < line.size(); i++) {
                int left = line.get(i);
                for (int j = i + 1; j < line.size(); j++) {
                    int right = line.get(j);
                    int code = 40000 * left + right;
                    if (edgeToX.containsKey(code)) {
                        int bottom = edgeToX.get(code);
                        int square = (x - bottom) * Math.abs(right - left);
                        minSquare = Math.min(minSquare, square);
                    }
                    edgeToX.put(code, x);
                }
            }
        }

        return minSquare == Integer.MAX_VALUE ? 0 : minSquare;
    }
}