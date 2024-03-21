package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Example 1:
//        Input: n = 9
//        Output: 6
//        Explanation:
//        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
//        arr = [2, 4, 6, 8]
//        arr = [2, 6]
//        arr = [6]
public class EliminationGame {
    static int result = 0;static int start = 0;
    public static int lastRemaining(int n) {

        return getLastRemaining(n,true);
    }

    private static int getLastRemaining(int n, boolean leftToRight) {
        if(n==1){
            return 1;
        }
        if(leftToRight || n%2 == 1){
            return 2 * getLastRemaining(n/2,!leftToRight);
        }
        else{
            return 2 * getLastRemaining(n/2,!leftToRight) - 1;
        }
    }

    public static  void main(String[] args) {
        int num = 9;
        System.out.println(lastRemaining(num));
    }
}
