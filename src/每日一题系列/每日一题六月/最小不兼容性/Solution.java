package 每日一题系列.每日一题六月.最小不兼容性;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {6, 3, 8, 1, 3, 1, 2, 2};
        int k = 4;
        System.out.println(solution.minimumIncompatibility(nums, k));
    }

    public int minimumIncompatibility(int[] nums, int k) {
        int subsetSize = nums.length / k;
        Arrays.sort(nums);
        int curMax = 0;
        int lastMax = 0;
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre || pre == -1) {
                curMax++;
                lastMax = Math.max(lastMax, curMax);
                pre = nums[i];
            } else {
                curMax = 1;
                pre = nums[i];
            }
        }
        if (lastMax > k) {
            return -1;
        }
        int status = 0;
        return fun(nums, k, status, subsetSize);
    }

    private int fun(int[] nums, int k, int status, int subsetSize) {
        if (status == (1 << nums.length) - 1 && k == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE / 2;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if ((status & (1 << i)) == 0) {
                if (set.contains(nums[i])) {
                    continue;
                }
                set.add(nums[i]);
//                int cur = (1 << i);
//                int next = status | cur;
                if (set.size() == subsetSize) {
                    System.out.println(Integer.toBinaryString(status) +" set " +  set);
                    res = Math.min(res, fun(nums, k - 1, status | (1 << i), subsetSize) + set.last() - set.first());
                } else {
                    res = Math.min(res, fun(nums, k, status | (1 << i), subsetSize));
                }
            }
        }
        return res;
    }


    private void printBinary(int next) {
        System.out.println(Integer.toBinaryString(next));
    }
}
