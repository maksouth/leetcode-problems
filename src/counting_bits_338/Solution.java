package counting_bits_338;

class Solution {
    public int[] countBits(int num) {
        int bits[] = new int[num + 1];
        bits[0] = 0;

        if (num > 0)
            bits[1] = 1;

        int currentPower = 1;

        for (int i = 2; i <= num; i++) {
            if (i == currentPower * 2) {
                bits[i] = 1;
                currentPower *= 2;
            } else {
                bits[i] = bits[currentPower] + bits[i - currentPower];
            }
        }

        return bits;
    }
}