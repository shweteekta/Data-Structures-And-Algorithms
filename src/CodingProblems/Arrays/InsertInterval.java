package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
//    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//    Output: [[1,2],[3,10],[12,16]]
//    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            // Before adding new interval
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            }
            // After adding new interval
            else if (newInterval[1] < intervals[i][0]) {
                result.add(newInterval);
                newInterval = intervals[i];
            } // Overlapping intervals
            else {
                newInterval[0] = Integer.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Integer.max(newInterval[1], intervals[i][1]);
            }
            i++;
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }
    public static void main(String[] args){
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        Arrays.stream(intervals)
                .flatMapToInt(Arrays::stream)
                .forEach(element -> System.out.print(element + " "));
        System.out.println("After ---");
        Arrays.stream(insert(intervals, newInterval))
                .flatMapToInt(Arrays::stream)
                .forEach(element -> System.out.print(element + " "));
    }
}
