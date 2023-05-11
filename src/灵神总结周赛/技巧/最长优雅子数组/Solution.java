package 灵神总结周赛.技巧.最长优雅子数组;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
    }
    public int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int l = 0, r = 0;
        int cur = 0;
        while (r < nums.length) {
            if ((cur & nums[r]) == 0) {
                cur |= nums[r];
            } else {
                while ((cur & nums[r]) != 0) {
                    cur ^= nums[l];
                    l++;
                }
                cur |= nums[r];
            }
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans;
        
    }
}
