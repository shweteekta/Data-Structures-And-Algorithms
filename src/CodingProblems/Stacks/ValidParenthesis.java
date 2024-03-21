package Stacks;
import java.util.*;
import java.util.Stack;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//        An input string is valid if:
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Every close bracket has a corresponding open bracket of the same type.
public class ValidParenthesis {
    public static  void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Map<Character, Character> map = Map.of('[', ']', '{', '}', '(', ')');
        Stack<Character> stack =new Stack<>();
        for (Character ch:s.toCharArray()
             ) {
            if(map.containsKey(ch)){
                stack.push(map.get(ch));
            }
            else{
                if(!stack.isEmpty() &&  !stack.peek().equals(ch) || !stack.contains(ch)){
                    return false;
                }
                stack.pop();

            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
