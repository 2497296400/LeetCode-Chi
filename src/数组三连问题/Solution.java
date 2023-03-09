package 数组三连问题;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, -2, 5, -3, 10};
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.process(arr, k));
    }

    public int process(int[] nums, int k) {
        //以当前位置为开头
        int[] minSum = new int[nums.length];
        int[] rightIndex = new int[nums.length];
        minSum[nums.length - 1] = nums[nums.length - 1];
        rightIndex[nums.length - 1] = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (minSum[i + 1] < 0) {
                minSum[i] = nums[i] + minSum[i + 1];
                rightIndex[i] = rightIndex[i + 1];
            } else {
                minSum[i] = nums[i];
                rightIndex[i] = i;
            }
        }
        int end = 0;
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < minSum.length; i++) {
            while (end < minSum.length && minSum[end] + sum <= k) {
                sum += minSum[end];
                end = rightIndex[end]+1;
            }
            ans = Math.max(ans, end - i);
            if (sum > k) {
                sum -= nums[i];
            } else {
                end = i + 1;
            }
        }
        return ans;
    }
}
