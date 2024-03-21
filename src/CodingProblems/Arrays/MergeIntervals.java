package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> result = new ArrayList<>();
      int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length ; i++) {
            if(intervals[i][0] > currentInterval[1]){
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
            else{
                currentInterval[0] = Integer.min(currentInterval[0], intervals[i][0]);
                currentInterval[1] = Integer.max(currentInterval[1], intervals[i][1]);
            }
        }
        result.add(currentInterval);
      return result.toArray(new int[result.size()][2]);
    }
    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        Arrays.stream(merge(intervals))
                .flatMapToInt(Arrays::stream)
                .forEach(element -> System.out.print(element + " "));
    }
}
