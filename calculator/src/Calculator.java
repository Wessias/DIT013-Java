import java.util.*;

import static java.lang.Double.NaN;
import static java.lang.Math.pow;


/*
 *   A calculator for rather simple arithmetic expressions
 *
 *   This is not the program, it's a class declaration (with methods) in it's
 *   own file (which must be named Calculator.java)
 *
 *   NOTE:
 *   - No negative numbers implemented
 */
public class Calculator {

    // Here are the only allowed instance variables!
    // Error messages (more on static later)
    final static String MISSING_OPERAND = "Missing or bad operand";
    final static String DIV_BY_ZERO = "Division with 0";
    final static String MISSING_OPERATOR = "Missing operator or parenthesis";
    final static String OP_NOT_FOUND = "Operator not found";

    // Definition of operators
    final static String OPERATORS = "+-*/^";

    // Method used in REPL
    double eval(String expr) {
        if (expr.length() == 0) {
            return NaN;
        }
        List<String> tokens = tokenize(expr);
        List<String> postfix = infix2Postfix(tokens);
        return evalPostfix(postfix);
    }

    // ------  Evaluate RPN expression -------------------

    double evalPostfix(List<String> postfix) {
        // TODO
        Stack<String> stack = new Stack<>();

        for (String tok : postfix) {
            if (OPERATORS.contains(tok)) {
                //Take top 2 from stack and apply operator to them.
                double operand1;
                double operand2;
                if(!stack.isEmpty() && !OPERATORS.contains(stack.peek())){
                    operand1 = Double.parseDouble(stack.pop());
                }
                else{
                    throw new IllegalArgumentException(MISSING_OPERAND);
                }
                if (!stack.isEmpty() && !OPERATORS.contains(stack.peek())){
                    operand2 = Double.parseDouble(stack.pop());
                }
                else {
                    throw new IllegalArgumentException(MISSING_OPERAND);
                }


                    double newVal = applyOperator(tok, operand1, operand2);
                    stack.push("" + newVal);

            } else {
                stack.push(tok);
            }
        }

        return Double.parseDouble(stack.pop());
    }

    double applyOperator(String op, double d1, double d2) {
        switch (op) {
            case "+":
                return d1 + d2;
            case "-":
                return d2 - d1;
            case "*":
                return d1 * d2;
            case "/":
                if (d1 == 0) {
                    throw new IllegalArgumentException(DIV_BY_ZERO);
                }
                return d2 / d1;
            case "^":
                return pow(d2, d1);
        }
        throw new RuntimeException(OP_NOT_FOUND);
    }

    // ------- Infix 2 Postfix ------------------------

    List<String> infix2Postfix(List<String> infix) {
        // TODO
        Stack<String> stack = new Stack<String>();
        List<String> output = new ArrayList<String>();


        for (String tok : infix) {
            if (tok.equals(")")) { //tok is ")"
                //Pop out and add to output til "(" found and pop out "("
                popTilParenthesisCloses(output, stack);
                stack.pop(); //Remove "("

            } else if (tok.equals("(")) { // tok is "("
                stack.push(tok);
            } else if (!OPERATORS.contains(tok)) {
                output.add(tok);
            } else {
                popHigherPrecedenceToOutput(output, stack, tok);
                stack.push(tok);
            }

        }
        //POP OUT ALL OPERATORS FROM STACK AND PUT IN OUTPUT
        while(!stack.isEmpty()){
            if(stack.peek().equals("(")){
                throw new IllegalArgumentException(MISSING_OPERATOR);
            }
            output.add(stack.pop());
        }
        return output;
    }

    void popTilParenthesisCloses(List<String> output, Stack<String> stack){
        while (!stack.peek().equals("(")) {
            output.add(stack.pop());
            if(stack.isEmpty()){
                throw new IllegalArgumentException(MISSING_OPERATOR);
            }
        }
    }


    void popHigherPrecedenceToOutput(List<String> output, Stack<String> stack, String tok){
        while (!stack.isEmpty()
                && !stack.peek().equals("(")
                && getPrecedence(tok) <= getPrecedence(stack.peek())
                && getAssociativity(tok).ordinal() == 0) {
            output.add(stack.pop());
        }
    }


    int getPrecedence(String op) {
        if ("+-".contains(op)) {
            return 2;
        } else if ("*/".contains(op)) {
            return 3;
        } else if ("^".contains(op)) {
            return 4;
        } else {
            throw new RuntimeException(OP_NOT_FOUND);
        }
    }

    Assoc getAssociativity(String op) {
        if ("+-*/".contains(op)) {
            return Assoc.LEFT;
        } else if ("^".contains(op)) {
            return Assoc.RIGHT;
        } else {
            throw new RuntimeException(OP_NOT_FOUND);
        }
    }

    enum Assoc {
        LEFT, RIGHT
    }

    // ---------- Tokenize -----------------------

    // List String (not char) because numbers (with many chars)
    List<String> tokenize(String expr) {
        // TODO
        List<String> tokens = new ArrayList<String>();
        String op = OPERATORS + "()";
        String num = "0123456789.";
        String tok = "";

        for (int i = 0; i < expr.length(); i++) {

            if (num.contains("" + expr.charAt(i))) {
                tok += expr.charAt(i);
            } else if (op.contains("" + expr.charAt(i))) {
                if (!tok.equals("")) {
                    tokens.add(tok);
                }
                tok = "";
                tokens.add("" + expr.charAt(i));
            }
            if (i == expr.length() - 1) {
                if (!tok.equals("")) {
                    tokens.add(tok);
                }

            }

        }

        if(tokens.size() == 1){
            String[] splitNum = expr.split(" ");
            if(splitNum.length != 1){
                throw new IllegalArgumentException(MISSING_OPERATOR);
            }
        }

        return tokens;
    }

}
