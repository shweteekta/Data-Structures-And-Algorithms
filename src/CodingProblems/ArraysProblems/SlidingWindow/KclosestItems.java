package ArraysProblems.SlidingWindow;

import java.util.*;

public class KclosestItems {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left=0;
        int right=arr.length-1;
        while(right-left>=k){
            if(x-arr[left]>arr[right]-x){
                left++;
            }else{
                right--;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=left;i<=right;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}
