package parse_lisp_expression_736;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private static final String LET = "let";
    private static final String ADD = "add";
    private static final String MULT = "mult";
    private static final char OP = '(';
    private static final char SPACE = ' ';

    private static final int SPACE_LENGTH = 1;
    private static final int OP_LENGTH = 1;
    private static final int CP_LENGTH = 1;

    private int position = 0;
    private String expression;

    public int evaluate(String expression) {
        this.expression = expression;
        return evaluate(new Context(null));
    }

    private int evaluate(Context context) {
        char current = expression.charAt(position);
        int result;

        if (current == OP)
            result = evaluateExpression(new Context(context));
        else if (Character.isLetter(current))
            result = evaluateVariable(context);
        else if (current == '-') {
          position++;
          result = -1 * parseNumber();
        } else if(Character.isDigit(current))
            result = parseNumber();
        else throw new IllegalArgumentException("Cannot evaluate '" + expression.substring(position) + "' " + position);

        return result;
    }

    private int parseNumber() {
        int start = position;
        while (position < expression.length() &&  Character.isDigit(expression.charAt(position)))
            position++;
        return Integer.parseInt(expression.substring(start, position));
    }

    private int evaluateVariable(Context context) {
        int variableNameEnd = readVariableNameEndIndex();
        String variableName = expression.substring(position, variableNameEnd);

        position = variableNameEnd;

        while (context != null)
            if (context.values.containsKey(variableName))
                return context.values.get(variableName);
            else context = context.parent;

        throw new IllegalArgumentException("Cannot find variable " + variableName);
    }

    private int evaluateExpression(Context context) {
        position += OP_LENGTH;

        new HashMap<>().size();
        int result;

        if (expression.startsWith(LET, position)) {
            readVariables(context);
            result = evaluate(context);
        } else if (expression.startsWith(ADD, position))
            result = sum(context);
        else if (expression.startsWith(MULT, position))
            result = mult(context);
        else throw new IllegalArgumentException("Cannot evaluate expression " + expression.substring(position));

        position += CP_LENGTH;
        return result;
    }

    private void readVariables(Context context) {
        position += LET.length() + SPACE_LENGTH;
        int variableNameEnd = readVariableNameEndIndex();

        while (expression.charAt(variableNameEnd) == SPACE) {
            String variableName = expression.substring(position, variableNameEnd);

            position = variableNameEnd + SPACE_LENGTH;

            int value = evaluate(context);
            context.values.put(variableName, value);

            removeWhitespaceIfAny();
            variableNameEnd = readVariableNameEndIndex();
        }
    }

    private int readVariableNameEndIndex() {
        int to = position;
        while (to < expression.length() && Character.isLetterOrDigit(expression.charAt(to)))
            to++;
        return to;
    }

    private void removeWhitespaceIfAny() {
        if (expression.charAt(position) == SPACE) position++;
    }

    private int sum(Context context) {
        position += ADD.length() + SPACE_LENGTH;
        int first = evaluate(context);
        position += SPACE_LENGTH;
        int second = evaluate(context);
        return first + second;
    }

    private int mult(Context context) {
        position += MULT.length() + SPACE_LENGTH;
        int first = evaluate(context);
        position += SPACE_LENGTH;
        int second = evaluate(context);
        return first * second;
    }

    private static class Context {
        final Context parent;
        Map<String, Integer> values = new HashMap<>();

        private Context(Context parent) {
            this.parent = parent;
        }
    }
}