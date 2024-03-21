package Stacks;

import java.util.Stack;
//Input: tokens = ["2","1","+","3","*"]
//        Output: 9
//        Explanation: ((2 + 1) * 3) = 9
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s:
             tokens) {
            if(Character.isDigit(s.charAt(0)) || (s.length() > 1 && Character.isDigit(s.charAt(1)))){
                stack.push(Integer.parseInt(s));
            }
            else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(doCalc(s,num1,num2));
            }
        }
        return stack.pop();
    }

    public static int doCalc(String op, int op1,int op2){
        switch (op){
            case "+":
                return op1 + op2;
            case "-":
                return op2 - op1;
            case "*":
                return op1 * op2;
            case "/":
                if (op1 == 0) {
                    return 0; // Avoid division by zero
                }
                return Math.floorDiv(op2, op1);
        }
        return 0;
    }
    public static  void main(String[] args){
        String[] exp = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(exp));
    }
}
