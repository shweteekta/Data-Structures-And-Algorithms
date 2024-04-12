package ArraysProblems;

import java.util.Arrays;

public class BagOfTokens {
//    Input: tokens = [100,200,300,400], power = 200
//    Output: 2
//    Explanation: Play the tokens in this order to get a score of 2:
//    Play token0 (100) face-up, reducing power to 100 and increasing score to 1.
//    Play token3 (400) face-down, increasing power to 500 and reducing score to 0.
//    Play token1 (200) face-up, reducing power to 300 and increasing score to 1.
//    Play token2 (300) face-up, reducing power to 0 and increasing score to 2.
    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int low = 0;
        int high = tokens.length - 1;
        int max = 0;
        while (low <= high){
            if (power >= tokens[low]){
                power = power - tokens[low];
                low++;
                score++;
                max = Integer.max(max, score);
            }
            else if (score > 0){
                power = power + tokens[high];
                high--;
                score--;
            }
            else{
                break;
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] tokens = {200,100,300,400};
        int power = 200;
        System.out.println(bagOfTokensScore(tokens,power));
    }
}
