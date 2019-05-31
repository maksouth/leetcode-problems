package decode_string_394;

import java.util.Arrays;

class Solution {
    private char[] data;
    private int current = 0;

    public String decodeString(String s) {
        data = s.toCharArray();
        return parseInput();
    }

    private String parseInput() {
        StringBuilder result = new StringBuilder();
        while (current < data.length && data[current] != ']') {
            if (Character.isDigit(data[current])) {
                result.append(parseExpression());
            } else result.append(readText());
        }
        current++;
        return result.toString();
    }

    private String readText() {
        int start = current;
        while (current < data.length && Character.isLetter(data[current]))
            current++;
        return new String(Arrays.copyOfRange(data, start, current));
    }

    private String parseExpression() {
        int number = readNumber();
        current++;
        String text = parseInput();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number; i++)
            result.append(text);
        return result.toString();
    }

    private int readNumber() {
        int number = 0;
        while (current < data.length && Character.isDigit(data[current]))
            number = 10 * number + data[current++] - '0';
        return number;
    }
}