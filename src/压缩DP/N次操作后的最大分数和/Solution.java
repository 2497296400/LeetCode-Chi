package 压缩DP.N次操作后的最大分数和;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,4,5,6};
        System.out.println(solution.maxScore(arr));
    }
    
    public static int gcd(int m, int n) {
        return m == 0 ? n : (gcd(n % m, m));
    }

    public int maxScore(int[] nums) {
        Integer[][] dp = new Integer[1 << nums.length+ 1][nums.length + 1];
        return fun(nums, 0, 0, dp);

    }

    private int fun(int[] nums, int curIndex, int status, Integer[][] dp) {
        if (curIndex * 2 == nums.length) {
            return 0;
        }
        if (dp[status][curIndex] != null) {
            return dp[status][curIndex];
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((status & (1 << i)) == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if ((status & (1 << j)) == 0) {
                        int cur = (1 << i) | (1 << j);
                        ans = Math.max(ans, fun(nums, curIndex + 1, status | cur, dp) + gcd(nums[i], nums[j]) * (curIndex + 1));
                    }
                }
            }
        }
        dp[status][curIndex] = ans;
        return ans;
    }
}
