package 每日一题系列.每日一题一月.将x减到0的最小操作数;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
        System.out.println(solution.minOperations(arr, 134365));
    }

    public int minOperations(int[] nums, int x) {
        long curSum = 0L;
        int start = 0;
        int end = nums.length - 1;
        int curAns = Integer.MAX_VALUE;
        for (int num : nums) {
            curSum += num;
            start++;
            if (curSum > x) {
                break;
            }
            if (curSum == x) {
                curAns = start;
            }
        }
        String cur;
        while (start > 0) {
            curSum -= nums[--start];
            while (end>=0&&curSum < x) {
                curSum += nums[end--];
            }
            if (curSum == x) {
                curAns = Math.min(curAns, nums.length - 1 - end + start);
            }
        }
        return curAns == Integer.MAX_VALUE ? -1:curAns;

    }
}