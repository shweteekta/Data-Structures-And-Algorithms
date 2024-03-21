package Matrix;

import java.util.ArrayList;
import java.util.List;

//Given an m x n matrix, return all elements of the matrix in spiral order.
//https://leetcode.com/problems/spiral-matrix/description/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int top = 0; int bottom = m -1; int left = 0; int right = n - 1;
        while (left <= right && top <= bottom){
            //left to right
            for(int i = left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            //top to bottom
            for (int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
            //right to left
            if(top <= bottom){
                for (int i = right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
