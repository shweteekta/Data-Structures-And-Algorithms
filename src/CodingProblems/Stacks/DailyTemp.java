package Stacks;

import java.util.Arrays;
import java.util.Stack;

//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
//        Example 1:
//Input: temperatures = [73,74,75,71,69,72,76,73]
//        Output: [1,1,4,2,1,1,0,0]
public class DailyTemp {
    public static int[] dailyTemperatures(int[] temp) {
        int[] result = new int[temp.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temp.length; i++) {
                while(!stack.isEmpty() && temp[ stack.peek()] < temp[i]){
                    int index = stack.pop();
                    result[index] = i - index;
                }
            stack.push(i);
        }
        return result;
    }
    public static  void main(String[] args){
        int[] temp = {73,74,75,71,69,72,76,73};
        Arrays.stream(dailyTemperatures(temp)).forEach(System.out::println);
    }
}
