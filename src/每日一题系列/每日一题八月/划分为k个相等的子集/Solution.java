package 每日一题系列.每日一题八月.划分为k个相等的子集;

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum  = 0;
        for (int i = 0; i < nums.length ; i++) {
            sum+= nums[i];
        }
        int target = sum / k;
        return  fun(nums, 0, target, new boolean[nums.length], k, 0);
    }

    private boolean fun(int[] nums, int index, int target, boolean[] vis, int k, int cueSum) {
        if (k == 0) {
            return true;
        }
        if (cueSum == target) {
            return fun(nums, 0, target, vis, k - 1, 0);
        }
        for (int i = index; i < nums.length; i++) {
            if (!vis[i] && cueSum + nums[i] <= target) {
                vis[i] = true;
                if (fun(nums, i + 1, target, vis, k, cueSum + nums[i])) {
                    return true;
                }
                vis[i] = false;
            }
        }
        return false;
    }
}
