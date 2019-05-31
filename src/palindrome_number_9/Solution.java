package palindrome_number_9;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int close10power = 1;
        int digitsNumber = 0;
        int copy = x;
        while (copy > 0) {
            copy /= 10;
            digitsNumber++;
        }
        close10power = (int)Math.pow(10, digitsNumber);

        for (int i = 0; i < digitsNumber / 2; i++) {
            if (x / close10power != x % 10) return false;

            x %= close10power;
            close10power /= 100;
            x /= 10;
        }

        return true;
    }
}