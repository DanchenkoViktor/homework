package ru.edu;

import java.util.*;

/**
 * Calculator.
 */
public class ExpressionCalculator {
    private Map<String, Integer> PRIORITIES = new HashMap<>();
    private Map<String, Integer> COUNT_ARGUMENTS = new HashMap<>();

    ExpressionCalculator() {
        PRIORITIES.put("+", 1);
        COUNT_ARGUMENTS.put("+", 2);
        PRIORITIES.put("-", 1);
        COUNT_ARGUMENTS.put("-", 2);
        PRIORITIES.put("*", 2);
        COUNT_ARGUMENTS.put("*", 2);
        PRIORITIES.put("/", 2);
        COUNT_ARGUMENTS.put("/", 2);
        PRIORITIES.put("cos", 3);
        COUNT_ARGUMENTS.put("cos", 1);
        PRIORITIES.put("sin", 3);
        COUNT_ARGUMENTS.put("sin", 1);
        PRIORITIES.put("КУБ", 3);
        COUNT_ARGUMENTS.put("КУБ", 1);
        PRIORITIES.put("КУБ2", 3);
        COUNT_ARGUMENTS.put("КУБ2", 2);

    }

    /**
     * Calculate expression e.g 2+3 -> 5.0
     *
     * @param expr - expression.
     */
    public double calculate(String expr) {
        List<String> rpn = toRPN(expr);
        Stack<Double> stack = new Stack<>();
        for (String item : rpn) {
            if (isDigit(item)) {
                stack.add(Double.parseDouble(item));
                continue;
            }
            double calculated = processItem(stack, item);
            stack.push(calculated);
        }
        return stack.pop();
    }

    private List<String> toRPN(String expr) {//1 КУБ 1 2 КУБ 10 * +
        List<String> rpn = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Tokenizer tokenizer = new Tokenizer(expr);
        while (tokenizer.hasNext()) {
            String token = tokenizer.next();
            if (isDigit(token)) {
                rpn.add(token);
                continue;
            }
            if (",".equals(token)) {
                popStackUntilOpenBracket(stack, rpn);
                continue;
            }
            if ("(".equals(token)) {
                stack.push(token);
                continue;
            }
            if (")".equals(token)) {
                popStackUntilOpenBracket(stack, rpn);
                continue;
            }
            if ("sin".equals(token) || "cos".equals(token) || "КУБ".equals(token)) {
                stack.push(token);
                continue;
            }
            if ("КУБ2".equals(token)) {
                stack.push(token);
                stack.push("("); // terminator
                continue;
            }
            popByOperationPriority(stack, rpn, token);
            stack.push(token);
        }
        while (!stack.isEmpty()) {
            rpn.add(stack.pop());
        }
        return rpn;
    }

    private boolean isDigit(String item) {
        try {
            double x = Double.parseDouble(item);
            return true;
        } catch (RuntimeException ex) {
            return false;
        }
    }

    private double processItem(Stack<Double> stack, String operator) {
        Double right = 0.0;
        Double left = 0.0;
        Double value = 0.0;
        if (COUNT_ARGUMENTS.get(operator) == 1) {
            value = stack.pop();
        } else if (COUNT_ARGUMENTS.get(operator) == 2) {
            right = stack.pop();
            left = stack.pop();
        } else throw new RuntimeException("Unsupported operation with many arguments");

        switch (operator) {
            case "+": {
                return left + right;
            }
            case "-": {
                return left - right;
            }
            case "*": {
                return left * right;
            }
            case "/": {
                return left / right;
            }
            case "cos": {
                return Math.cos(value);
            }
            case "sin": {
                return Math.sin(value);
            }
            case "КУБ": {
                return Math.pow(value, 3);
            }
            case "КУБ2": {
                return Math.pow(left, 3) + Math.pow(right, 3);
            }
        }
        throw new RuntimeException("Unsupported operation = " + operator);
    }

    private void popByOperationPriority(Stack<String> stack, List<String> rpn, String newOperation) {
        while (!stack.isEmpty()) {
            String currItem = stack.peek();
            if (currItem.equals("(")) {
                break;
            }
            if (PRIORITIES.get(currItem) >= PRIORITIES.get(newOperation)) {
                rpn.add(stack.pop());
            } else break;
        }
    }

    private void popStackUntilOpenBracket(Stack<String> stack, List<String> rpn) {
        while (!stack.isEmpty()) {
            String tmp = stack.pop();
            if (tmp.equals("(")) {
                break;
            } else {
                rpn.add(tmp);
            }
        }
    }
}