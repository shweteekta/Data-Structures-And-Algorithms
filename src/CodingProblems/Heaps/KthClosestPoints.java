package Heaps;

import java.util.Arrays;

public class KthClosestPoints {
//    Input: points = [[1,3],[-2,2]], k = 1
//    Output: [[-2,2]]
//    Explanation:
//    The distance between (1, 3) and the origin is sqrt(10).
//    The distance between (-2, 2) and the origin is sqrt(8).
//    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//    We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
        public int[][] kClosest(int[][] points, int k) {
            int n = points.length;
            for (int i=(n/2-1); i >= 0; i--){
                minHeapify(i, points);
            }
            for (int i = n - 1; i >= n - k; i--) {
                swap(0, i, points);
                minHeapify(i, points);
            }
            return Arrays.copyOfRange(points, n - k, n);
        }

        private void minHeapify(int index, int[][]points){
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;
            if (left < points.length && calc(points[left]) < calc(points[index])){
                largest = left;
            }
            if (right < points.length && calc(points[right]) < calc(points[largest])){
                largest = right;
            }
            if (largest != index){
                swap(largest, index,points);
                minHeapify(largest,points);
            }
        }

        private double calc(int[] coord){
            return Math.sqrt(Math.pow(coord[0], 2) + Math.pow(coord[1], 2));
        }

        private void swap(int index, int index2, int[][]points) {
            int[] temp = points[index];
            points[index] = points[index2];
            points[index2] = temp;
        }

}
