package task1.Calculate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import task1.FileChooser;

class Expression {

    public BigDecimal left, right;
    public String operator;

    public Expression(BigDecimal left, BigDecimal right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
}

public class Calculate {

    private static boolean isIntegerValue(BigDecimal bd) {
        boolean ret;

        try {
            bd.toBigIntegerExact();
            ret = true;
        } catch (ArithmeticException ex) {
            ret = false;
        }

        return ret;
    }

    public static void evaluate(Expression exp) {
        switch (exp.operator) {
            case "ADD" -> System.out.println(exp.left.add(exp.right));
            case "SUB" -> System.out.println(exp.left.subtract(exp.right));
            case "MULT" -> System.out.println(exp.left.multiply(exp.right));
            case "POW" -> {
                if ((exp.right.signum() > 0) && (exp.right.compareTo(new BigDecimal("999999999")) < 0)
                        && isIntegerValue(exp.left)) {
                    System.out.println(exp.left.pow(exp.right.intValue()));
                } else {
                    System.out.println("Number " + exp.right + " is out of limits or left part is not integer.");
                }

            }
            case "DIV" -> {
                if (!exp.right.equals(BigDecimal.ZERO)) {
                    System.out.println(exp.left.divideToIntegralValue(exp.right));
                } else {
                    System.out.println("Divisor cannot be zero.");
                }
            }
            case "REM" -> {
                if (!exp.right.equals(BigDecimal.ZERO)) {
                    System.out.println(exp.left.remainder(exp.right));
                } else {
                    System.out.println("Divisor cannot be zero.");
                }
            }
            default -> throw new IllegalArgumentException("Unexpected value");
        }
    }

    public static Expression validator(String expression) {

        String[] parts = expression.toUpperCase().split("\\s+");

        if (parts.length != 3) {
            System.out.println(
                    "Expression \"" + expression + " \" couldn't be evaluated because it has upapropitate length.");
        } else if (!parts[2].matches("ADD|SUB|MULT|DIV|REM|POW")) {
            System.out.println(
                    "Expression \"" + expression + " \" couldn't be evaluated because it has upapropitate operation.");
            return null;
        }

        try {
            BigDecimal left = new BigDecimal(parts[0]);
            BigDecimal right = new BigDecimal(parts[1]);
            String operator = new String(parts[2]);
            return new Expression(left, right, operator);
        } catch (NumberFormatException e) {
            System.out.println(
                    "First or second part of expression \"" + expression + " \" couldn't be represented as a number.");
            return null;
        }

    }

    public static void main(String[] args) throws IOException {

        new FileChooser();
        BufferedReader bf = new BufferedReader(new FileReader(FileChooser.choser()));

        try {

            String line = bf.readLine();
            while (line != null) {

                try {
                    Expression validated = validator(line);
                    evaluate(validated);
                } catch (NullPointerException e) {
                }

                line = bf.readLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("File couldn't be found.");
        }
        bf.close();
    }

}