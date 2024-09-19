package 每日一题系列.每日一题八月.特殊数组II;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,5,2,7};
        int[][] queries = {{1, 3}};
        System.out.println(Arrays.toString(solution.isArraySpecial(nums, queries)));
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] preSun = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
        }
        preSun[0] = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i - 1]) {
                preSun[i] = nums[i];
            } else {
                preSun[i] = preSun[i - 1] + nums[i];
            }
        }
        boolean[] ans = new boolean[queries.length];
        Arrays.fill(ans, false);
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if(l==r){
                ans[i] = true;
                continue;
            }
            int sub = r - l;
            int ln = nums[l];
            int rn = nums[r];
            int sum = preSun[r] - preSun[l];
            if (sub % 2 == 0) {
                if (ln == rn && sum  == sub/2) {
                    ans[i] = true;
                }
            } else {
                if (ln != rn && sum == sub/2) {
                    ans[i] = true;
                }
            }
        }
        return ans;
    }

}
