package 动态规划问题.最长递增子序列;

import java.util.Arrays;

public class Dome {
    public static void main(String[] args) {
        Solution01 s = new Solution01();
        Test test = new Test();
        int[] nums = getRandomArray(100, 100);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(s.lengthOfLIS(nums)));
        System.out.println(test.lengthOfLIS(nums));
        System.out.println(new DFSTest().longestIncreasingSubsequence(nums));
    }

    private static int[] getRandomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen) + 1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue) + 1;
        }
        return arr;
    }
}
