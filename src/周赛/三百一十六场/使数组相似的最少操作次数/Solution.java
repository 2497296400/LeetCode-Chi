package 周赛.三百一十六场.使数组相似的最少操作次数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr={8,12,6};
        int [] srr={2,14,10};
        System.out.println(solution.makeSimilar(arr, srr));
    }
    public long makeSimilar(int[] nums, int[] target) {
        long ans = 0;
        Arrays.sort(nums);
        Arrays.sort(target);
        int f = 0, s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                while (f<target.length&&target[f] % 2 != 0) {
                    f++;
                }
                ans += Math.abs(target[f++]-nums[i]);
            } else {
                while (s<target.length&&target[s] % 2 == 0) {
                    s++;
                }
                ans += Math.abs(target[s++] - nums[i]);
            }
        }
        return ans >> 2;
    }
}
