package Top集合.K个不同整数的子数组参窗口问题;

public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return process(nums, k) - process(nums, k - 1);
    }

    private int process(int[] nums, int k) {
        int[] map = new int[nums.length+1];
        int l = -1;
        int r = 0;
        int cur = 0;
        int ans = 0;
        while (r < nums.length) {
            if (map[nums[r++]]++ == 0) {
                cur++;
            }
            while (cur > k) {
                if (--map[nums[++l]] == 0) {
                    cur--;
                }
            }
            ans += r - l-1;
        }
        return ans;
    }
}
