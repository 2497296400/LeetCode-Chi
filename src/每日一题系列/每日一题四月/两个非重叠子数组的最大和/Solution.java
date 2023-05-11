package 每日一题系列.每日一题四月.两个非重叠子数组的最大和;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 0, 1};
        System.out.println(solution.maxSumTwoNoOverlap(arr, 1, 1));
    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int maxAns = 0;
        return maxAns = Math.max(fun(preSum, firstLen, secondLen)
                , fun(preSum, secondLen, firstLen));
    }

    private int fun(int[] preSum, int firstLen, int secondLen) {
        int maxSumA = 0, res = 0;
        for (int i = firstLen + secondLen; i < preSum.length; i++) {
            maxSumA = Math.max(maxSumA, preSum[i - secondLen] - preSum[i - secondLen - firstLen]);
            res = Math.max(res, maxSumA + preSum[i] - preSum[i - secondLen]);
        }
        return res;
    }
}