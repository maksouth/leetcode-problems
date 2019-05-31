package stone_game_877;

class Solution {
    public boolean stoneGame(int[] piles) {
        int[] dp = new int[piles.length];

        for (int s = piles.length-2; s >= 0; s--)
            for (int e = s+1; e < piles.length; e++)
                dp[e] = Math.max(piles[s] - dp[e], piles[e] - dp[e - 1]);

        return dp[dp.length-1] > 0;
    }
}