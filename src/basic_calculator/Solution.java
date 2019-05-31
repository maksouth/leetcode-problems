package basic_calculator;

class Solution {
    private int current = 0;
    private char[] expression;

    public int calculate(String s) {
        s = s.replace(" ", "");
        expression = s.toCharArray();
        return parseInput();
    }

    private int parseInput() {
        int result = readOperand();
        while (current < expression.length && expression[current] != ')') {
            int operation = readOperation();
            int operand = readOperand();
            result += operation * operand;
        }

        current++;
        return result;
    }

    private int readOperation() {
        int operation;
        if (expression[current] == '+') operation = 1;
        else operation = -1;
        current++;
        return operation;
    }

    private int readOperand() {
        int result;
        if (expression[current] == '(')
            result = evaluateExpression();
        else result = readNumber();

        return result;
    }

    private int evaluateExpression() {
        current++;
        return parseInput();
    }

    private int readNumber() {
        int number = 0;
        while (current < expression.length && Character.isDigit(expression[current])) {
            int digit = expression[current] - '0';
            number = number * 10 + digit;
            current++;
        }

        return number;
    }
}