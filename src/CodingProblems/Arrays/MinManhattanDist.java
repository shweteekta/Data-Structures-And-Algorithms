package Arrays;
import java.util.*;

public class MinManhattanDist {
//    You are given a 0-indexed array points representing integer coordinates of some points on a 2D plane, where points[i] = [xi, yi].
//    The distance between two points is defined as their
//    Return the minimum possible value for maximum distance between any two points by removing exactly one point.
//            Example 1:
//    Input: points = [[3,10],[5,15],[10,2],[4,4]]
//    Output: 12
//    Explanation: The maximum distance after removing each point is the following:
//            - After removing the 0th point the maximum distance is between points (5, 15) and (10, 2), which is |5 - 10| + |15 - 2| = 18.
//            - After removing the 1st point the maximum distance is between points (3, 10) and (10, 2), which is |3 - 10| + |10 - 2| = 15.
//            - After removing the 2nd point the maximum distance is between points (5, 15) and (4, 4), which is |5 - 4| + |15 - 4| = 12.
//            - After removing the 3rd point the maximum distance is between points (5, 15) and (10, 2), which is |5 - 10| + |15 - 2| = 18.
//    It can be seen that 12 is the minimum possible maximum distance between any two points after removing exactly one point.
    public int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> xPlusY = new TreeMap<>();
        TreeMap<Integer, Integer> xMinusY = new TreeMap<>();
        for (int[] point : points) {
            int sum = point[0] + point[1];
            int difference = point[0] - point[1];

            xPlusY.put(sum, xPlusY.getOrDefault(sum, 0) + 1);
            xMinusY.put(difference, xMinusY.getOrDefault(difference, 0) + 1);
        }

        int res = Integer.MAX_VALUE;
        for (int[] point : points) {
            int sum = point[0] + point[1];
            int difference = point[0] - point[1];

            // simulate removal
            xPlusY.put(sum, xPlusY.get(sum) - 1);
            if (xPlusY.get(sum) == 0) {
                xPlusY.remove(sum);
            }
            xMinusY.put(difference, xMinusY.get(difference) - 1);
            if (xMinusY.get(difference) == 0) {
                xMinusY.remove(difference);
            }

            res = Math.min(Math.max(Math.abs(xPlusY.lastKey() - xPlusY.firstKey()), Math.abs(xMinusY.lastKey() - xMinusY.firstKey())), res);

            // backtrack
            xPlusY.put(sum, xPlusY.getOrDefault(sum, 0) + 1);
            xMinusY.put(difference, xMinusY.getOrDefault(difference, 0) + 1);
        }

        return res;
    }
}
