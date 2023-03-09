package 动态规划问题.最长递增子序列;

import java.util.Arrays;

public class Dome {
    public static void main(String[] args) {
        Solution01 s = new Solution01();
        Test test = new Test();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(Arrays.toString(s.lengthOfLIS(nums)));
        System.out.println(test.lengthOfLIS(nums));
    }
}
