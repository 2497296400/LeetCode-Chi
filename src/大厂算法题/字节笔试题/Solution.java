package 大厂算法题.字节笔试题;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 4, 6, 8};
        int limit = 866869;
        System.out.println(solution.getMaxLimit(limit, nums));
    }

    public int getMaxLimit(int limit, int[] nums) {
        limit--;
        int offet = 1;
        while (offet <= limit / 10) {
            offet *= 10;
        }
         Arrays.sort(nums);
        int ans = fun(limit, nums, offet);

        if (ans == -1) {
            ans = getData(nums, offet);
        }
        return ans;
    }

    private int fun(int limit, int[] nums, int offet) {
        if (offet == 0) {
            return limit;
        }
        int cur = (limit / offet)%10;
        int getCur = near(cur, nums);
        if (getCur == -1) {
            return -1;
        } else if (nums[getCur] == cur) {

            int next = fun(limit, nums, offet / 10);

            if (next != -1) {
                return next;
            } else if (getCur > 0) {
                return (limit / (offet * 10) * offet * 10 + nums[getCur-1] * offet + getData(nums, offet/10));
            } else {
                return -1;
            }
        } else {
            return (limit / (offet * 10) * offet * 10 + nums[getCur] * offet + getData(nums, offet/10));
        }
    }


    private int near(int cur, int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= cur) {
                return i;
            }
        }
        return -1;
    }

    private int getData(int[] nums, int offet) {
        int cur = 0;
        while (offet != 0) {
            cur += nums[nums.length - 1]*offet;
            offet /= 10;
        }
        return cur;
    }
}
