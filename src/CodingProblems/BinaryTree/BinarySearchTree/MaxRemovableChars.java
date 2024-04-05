package BinaryTree.BinarySearchTree;

public class MaxRemovableChars {
//    You are given two strings s and p where p is a subsequence of s. You are also given a distinct 0-indexed integer array removable containing a subset of indices of s (s is also 0-indexed).
//
//    You want to choose an integer k (0 <= k <= removable.length) such that, after removing k characters from s using the first k indices in removable, p is still a subsequence of s. More formally, you will mark the character at s[removable[i]] for each 0 <= i < k, then remove all marked characters and check if p is still a subsequence.
//
//    Return the maximum k you can choose such that p is still a subsequence of s after the removals.
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        int low = 0;
        int high = removable.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            for (int i = low; i <= mid; i++)
                sArray[removable[i]] = '*';
            if (isSubsequence(sArray, pArray)) {
                low = mid + 1;
            } else {
                for (int i = low; i <= mid; i++)
                    sArray[removable[i]] = s.charAt(removable[i]);
                high = mid - 1;
            }
        }
        return high + 1;

    }

    private boolean isSubsequence(char[] s, char[] p) {
        int i = 0, j = 0;
        while(i < s.length && j < p.length){
            if(s[i] == p[j]){
                i++;
                j++;
            }
            else i++;
        }
        return j == p.length;
    }
}
