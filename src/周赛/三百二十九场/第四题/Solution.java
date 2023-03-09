package 周赛.三百二十九场.第四题;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 1, 2, 1, 3, 3};
        System.out.println(solution.minCost(arr, 2));
    }

    public int minCost(int[] nums, int k) {
        Long[] ans = new Long[nums.length + 1];
        return (int) fun(nums, 0, k, ans);
    }

    private int fun(int[] nums, int index, int k, Long[] ans) {
        if (index == nums.length) {
            return 0;
        }
        if (ans[index] != null) {
            return Math.toIntExact(ans[index]);
        }
        int cnt = 0;
        int[] temp = new int[nums.length + 1];
        int value = Integer.MAX_VALUE;
        for (int cur = index; cur < nums.length; cur++) {
            temp[nums[cur]] += 1;
            if (temp[nums[cur]] == 2) cnt += 2;
            else if (temp[nums[cur]] > 2) cnt += 1;
            value = Math.min(value, fun(nums, cur + 1, k, ans) + cnt + k);
        }
        ans[index] = Long.valueOf(value);
        return value;
    }
}
