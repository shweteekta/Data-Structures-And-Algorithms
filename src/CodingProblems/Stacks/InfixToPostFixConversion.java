package Stacks;

import java.util.List;
import java.util.Stack;

public class InfixToPostFixConversion {

    public static int evaluatePostFix(String exp){
        Stack<Integer> stack = new Stack<>();
        for (char c: exp.toCharArray() ) {
            if(Character.isLetterOrDigit(c)){
                stack.push(Character.getNumericValue(c));
            }
            else{
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(performOperation(op1,op2,c));
            }
        }
        return stack.pop();
    }

    public static String infixToPostFix(String exp){
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (char c : exp.toCharArray()) {
            if(!checkOperators(c)){
                postfix.append(c);
            }
            else if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                while(!stack.isEmpty() &&  stack.peek() != '('){
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek()) )
                {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static boolean checkOperators(char op){
        return List.of('*','/','^','+','-','(',')').contains(op);
    }

    private static int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
            case '^':
                return (int) Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static int precedence(char op){
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args){
        String strexp1 = "110+50"; // => 160
        String strexp2 = "110+50+(4-2*5)-10+40"; // => 184
        String strexp3 = "(110+50)*(2-4)"; //=> -320
        String strexp4 = "2^5*(3-4)"; // => -32
        String strexp5 = "2^5"; // => 32
        String strexp6 = "0-8-0-5^3"; // => -133
        System.out.println("PostfixExpression =  " + infixToPostFix(strexp1));
        System.out.println("Evaluation =" + evaluatePostFix(infixToPostFix(strexp1)));
    }

}
