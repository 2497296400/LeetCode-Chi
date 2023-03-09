package 动态规划问题.最长递增子序列;

import java.util.Arrays;

public class Solution01 {
    public static void main(String[] args) {
        Solution01 solution = new Solution01();
        int []arr={10,9,2,5,3,7,101,18};
        System.out.println(Arrays.toString(solution.lengthOfLIS(arr)));
    }
    public int[] lengthOfLIS(int[] nums) {
        int[] end = new int[nums.length];
        end[0] = nums[0];
        int endSize = 1;
        for (int i = 1; i < nums.length; i++) {
            int l = 0;
            int r = endSize;
            int flag = toGet(l, r, nums[i], end);
            if (flag == -1) {
                end[endSize++] = nums[i];
            } else {
                end[flag] = nums[i];
            }
        }

        return Arrays.copyOf(end, endSize) ;
    }

    private int toGet(int l, int r, int num, int[] endSize) {
        int flag = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (endSize[mid] >= num) {
                flag = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return flag;
    }
}
