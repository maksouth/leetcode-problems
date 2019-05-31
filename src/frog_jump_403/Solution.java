package frog_jump_403;

import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length >= 2 && stones[1] - stones[0] > 1) return false;
        Map<Integer, Set<Integer>> jumpSize = new HashMap<>();

        for (int stone : stones) {
            jumpSize.put(stone, new HashSet<>());
        }
        jumpSize.get(1).add(1);

        for (int i = 1; i < stones.length - 1; i++) {
            Set<Integer> jumps = jumpSize.get(i);
            for (Integer jump: jumps) {
                int nextStone = stones[i] + jump;
                jumpSize.computeIfPresent(nextStone, (ignored, nextJumps) -> {
                    nextJumps.add(jump);
                    nextJumps.add(jump + 1);
                    if (jump - 1 != 0) nextJumps.add(jump - 1);
                    return nextJumps;
                });
            }
        }

        return !jumpSize.get(stones.length - 1).isEmpty();
    }
}