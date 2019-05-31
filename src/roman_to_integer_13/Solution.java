package roman_to_integer_13;

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = convert(s.charAt(i));
            int next = next(i+1, s);
            if (current < next) sum -= current;
            else sum += current;
        }

        return sum;
    }

    private int next(int i, String number) {
        if (i >= number.length()) return -1;
        return convert(number.charAt(i));
    }

    private int convert(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}