package Recursion;

import java.util.*;

//Print all balanced parenthesis of length n in lexicographic order.
//        Constraints
//        2 ≤ n ≤ 24
//        It is guaranteed that n is even.
//
//        Sample Input 1
//        2
//        Sample Output 1
//        ()
//        Sample Input 2
//        4
//        Sample Output 2
//        (())
//        ()()
public class BalancedParenthesis {
    public static void main(String[] args){
        int n = 4;
        System.out.println(getBalancedParenthesis(n));
    }

    private static List<String> getBalancedParenthesis(int n) {
        List<String> result = new ArrayList<>();
        rec(0, n, result, new StringBuilder(), 0);
        return result;
    }

    private static void rec(int i, int n, List<String> result, StringBuilder str, int sum) {
        if (sum < 0) {return;}
        if ( i == n) {
            if (sum == 0){
                result.add(str.toString());
            }
            return;
        }
        rec(i + 1, n, result, str.append("("), sum + 1);
        str.deleteCharAt(str.length() - 1);
        rec(i + 1, n, result, str.append(")"), sum - 1);
        str.deleteCharAt(str.length() - 1);
    }
}
