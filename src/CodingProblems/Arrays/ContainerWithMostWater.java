package Arrays;
//Input: height = [1,8,6,2,5,4,8,3,7]
//        Output: 49
//        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
     int maxArea = 0;
     int w = 1; int h = 1;
     // This solution provides Time Limit Exceeded
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1 ; j < height.length ; j++) {
//                maxArea = Integer.max(maxArea,Integer.min(height[i], height[j]) * (j-i));
//            }
//        }
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            w = right - left;
            if (height[left] < height[right]){
                h = height[left];
                left ++;
            }
            else{
                h = height[right];
                right --;
            }
            maxArea = Integer.max(maxArea, h * w);
        }
     return maxArea;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
