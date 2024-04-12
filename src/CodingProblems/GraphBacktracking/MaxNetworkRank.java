package GraphBacktracking;

import java.util.HashMap;
import java.util.*;

public class MaxNetworkRank {
    static int maxPath = 0;

    public static int solution(int[] A, int[] B, int N) {
        int[] edgeCount = new int[N];
        int maxRank = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            edgeCount[A[i] - 1]++;
            edgeCount[B[i] - 1]++;
        }

        for (int i = 0; i < A.length; i++) {
            int rank = edgeCount[A[i] - 1] + edgeCount[B[i] - 1] - 1;
            if (rank > maxRank) {
                maxRank = rank;
            }
        }

        return maxRank;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4,5};
        int[] B = {2, 3, 5,6};
        int N = 6;
        System.out.println(solution(A, B, N));
    }
}
