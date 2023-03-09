package 双指针问题.盛水问题;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int righ = height.length - 1;
        int ans = 0;
        while (left < righ) {
            int min = Math.min(height[left], height[righ]);
            int temp = min * (righ - left);
            ans = Math.max(ans, temp);
            while (height[left] <= min && left < righ) {
                left++;
            }
            while (height[righ] <= min && left < righ) {
                righ--;
            }

        }
        return ans;
    }
}
