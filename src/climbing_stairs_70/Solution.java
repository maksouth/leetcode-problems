package climbing_stairs_70;

class Solution {
    public int climbStairs(int n) {
        return fibonacci(n);
    }

    private int fibonacci(int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            int temp = a;
            a = b;
            b += temp;
        }

        return b;
    }
}
