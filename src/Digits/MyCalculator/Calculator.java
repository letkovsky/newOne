package Digits.MyCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String[] tokens;
    private int pos = 0;

    public Calculator(String expression) {
        this.tokens = convert(expression);
    }


    public static void main(String[] args) {

        String exp = "10-5*(3+4)+2";
        Calculator calculator = new Calculator(exp);
        System.out.println(calculator.calculate());
        System.out.println(10-5.0*(3+4)+2);

    }

    private String[] convert(String exp) {

        String[] split = exp.split("");
        String example = "0123456789";

        for (int i = 0; i < split.length - 1; i++) {
            if (example.contains(split[i + 1]) && example.contains(split[i])) {
                split[i] += split[i + 1];
                split[i + 1] = null;
            }
        }
        String[] strings = Arrays.stream(split)
                .filter(e -> e != null)
                .toArray(String[]::new);
        return strings;
    }

    public double calculate() {
        double first = multiply();
        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }
            double second = multiply();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    private double multiply() {
        double first = factor();
        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                pos++;
            }
            double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    private double factor() {
        String next = tokens[pos];
        double result;
        if (next.equals("(")) {
            pos++;
            result = calculate();
            String last;
            if (pos < tokens.length) {
                last = tokens[pos];
            } else {
                throw new IllegalArgumentException("Unexpected end of expression");
            }
            if (last.equals(")")) {
                pos++;
                return result;
            } else {
                throw new IllegalArgumentException("')' expected but" + last + " found");
            }

        } else {
            pos++;
            return Double.parseDouble(next);
        }
    }
}
