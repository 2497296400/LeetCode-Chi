package 灵神总结周赛.技巧.统计定界子数组的数目;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,1,1,1};
        System.out.println(solution.countSubarrays(arr, 1, 1));
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int l = 0, r = 0;
        int posf = -1;
        int poss = -1;
        while (r < nums.length) {
            if (nums[r] == minK) {
                posf = r;
            }
            if (nums[r] == maxK) {
                poss = r;
            }
            if (nums[r] > maxK || nums[r] < minK) {
                l = r + 1;
            }
            r++;
            ans += Math.max(0, Math.min(posf, poss) - l+1);
        }
        return ans;
    }
}
