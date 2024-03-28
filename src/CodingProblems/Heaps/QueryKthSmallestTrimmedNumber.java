package Heaps;

import java.util.*;

//Example 1:
//        Input: nums = ["102","473","251","814"}, queries = [[1,1],[2,3],[4,2],[1,2]]
//        Output: [2,2,1,0]
//        Explanation:
//        1. After trimming to the last digit, nums = ["2","3","1","4"]. The smallest number is 1 at index 2.
//        2. Trimmed to the last 3 digits, nums is unchanged. The 2nd smallest number is 251 at index 2.
//        3. Trimmed to the last 2 digits, nums = ["02","73","51","14"]. The 4th smallest number is 73.
//        4. Trimmed to the last 2 digits, the smallest number is 2 at index 0.
public class QueryKthSmallestTrimmedNumber {
    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        HashMap<Integer, Node[]> map = new HashMap<>();
        int[] res = new int[queries.length];
        int idx = 0, len = nums[0].length();
        for (int[] query : queries) {
            if (!map.containsKey(query[1])) {
                Node[] arr = new Node[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    String x = nums[i].substring(len - query[1], len);
                    arr[i] = new Node(i, x);
                }
                Arrays.sort(arr, (a, b) -> a.val.compareTo(b.val));
                map.put(query[1], arr);
            }
            res[idx++] = map.get(query[1])[query[0] - 1].index;
        }
        return res;
    }
    static class Node{ int index; String val;
        Node(int i, String v){ this.index = i; this.val = v; } }

    public static void main(String[] args){
        String[] nums = {"102","473","251","814"};
        int[][] queries = {{1,1},{2,3},{4,2},{1,2}};
        for (int i : smallestTrimmedNumbers(nums, queries)) {
            System.out.println(i);
        }
    }
}
