package can_i_win_464;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal == 0) return true;

        BitSet used = new BitSet(maxChoosableInteger+1);
        Map<String, Boolean> tried = new HashMap<>();
        return canIWin(desiredTotal, maxChoosableInteger, used, tried);
    }

    private boolean canIWin(int desiredTotal, int max, BitSet used, Map<String, Boolean> tried) {
        String key = used.toString();
        if (desiredTotal <= 0) return false;
        if (tried.containsKey(key))
            return tried.get(key);

        boolean result = false;
        for (int i = 1; i <= max; i++)
            if (!used.get(i)) {
                used.set(i);

                if (!canIWin(desiredTotal - i, max, used, tried)) {
                    result = true;
                    used.clear(i);
                    break;
                }

                used.clear(i);
            }

        tried.put(key, result);
        return result;
    }
}
