package 周赛.三百零九.最长优雅子数组;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 8, 48, 10};
        System.out.println(solution.longestNiceSubarray(nums));
    }

    public int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int[] temp = new int[32];
        int strat = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int cur = 31; cur >= 0; cur--) {
                if ((nums[i] >> cur & 1) == 1) {
                    temp[cur]++;
                }
            }

            for (int cur = 31; cur >= 0; cur--) {
                if (temp[cur] > 1) {
                    for (int j = 31; j >= 0; j--) {
                        if((nums[strat]>>j&1)==1){
                            temp[j]--;
                        }
                    }
                    strat++;
                    break;
                }
            }
            ans=Math.max(ans, i-strat+1);
        }
        return ans;
    }
}