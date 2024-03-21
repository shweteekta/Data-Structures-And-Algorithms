package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PermuationsSequence {
    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(getPermutations(n, k));
    }

    private static String getPermutations(int n, int k) {
        StringBuilder result = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        getPermutations(n, k, result, new ArrayList<>(), count);
        return result.toString();
    }

    private static void getPermutations(int n, int k, StringBuilder result, List<Integer> temp, AtomicInteger count) {
        if (temp.size() == n) {
            if (count.intValue() == k - 1) {
                for (int i : temp
                ) {
                    result.append(i);
                }
            }
            count.incrementAndGet();

            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (count.intValue() == k) {
                return;
            }
            if (!temp.contains(i)) {
                temp.add(i);
                getPermutations(n, k, result, temp, count);
                temp.remove(temp.size() - 1);
            }
        }
    }


    // Optimised soln as current one produces TLE
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            list.add(i);
        }
        list.add(n);
        k = k - 1;
        String ans = "";
        while (true) {
            ans += list.get(k / fact);
            list.remove(k / fact);
            if (list.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / list.size();
        }
        return ans;
    }
}