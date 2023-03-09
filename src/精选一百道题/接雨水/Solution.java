package 精选一百道题.接雨水;

public class Solution {
    public static void main(String[] args) {
        int []nums={2,0,2};
        System.out.println(trap(nums));
    }
    public static int trap(int[] height) {
        if(height.length<2){
            return 0;
        }
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 0;
        int sum = 0;
        int len = height.length;
        int rigit = len - 1;
        int index = height[left] < height[rigit] ? left + 1 : rigit - 1;
        while (left < rigit-1) {
            int temp = Math.min(leftMax - height[index], rightMax - height[index]);
            sum += Math.max(temp, 0);
            if (index == left + 1) {
                leftMax = Math.max(leftMax, height[index]);
                left++;
            } else if (index == rigit - 1) {
                rightMax = Math.max(rightMax, height[index]);
                rigit--;
            }
            index = leftMax < rightMax ? left + 1 : rigit - 1;
        }
        return sum;
    }
}
