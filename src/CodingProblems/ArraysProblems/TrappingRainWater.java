package ArraysProblems;

public class TrappingRainWater {
    public int trap(int[] height) {
        int maxLeft = height[0];
        int total = 0;
        int n = height.length;
        int[] right = new int[n];
        int maxRight = height[n-1];
        // Check for LeftMax and RightMax and remove the current element from it;
        for (int i=n-1;i >=0; i--){
            right[i] = maxRight;
            maxRight = Math.max(maxRight,height[i]);
        }
        for (int i=0; i< n;i++){
            total = total + Math.max((Math.min(maxLeft,right[i]) - height[i]),0);
            maxLeft = Math.max(maxLeft,height[i]);
        }
        return total;
    }
}
