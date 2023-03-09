package 每日一题系列.每日一题十月.最大升序子数组和;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10, 20, 30, 5, 10, 50};
        System.out.println(solution.maxAscendingSum(arr));
    }

    public int maxAscendingSum(int[] nums) {

        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = 0;
            sum += nums[i];
            while (i < nums.length - 1 && nums[i + 1] > nums[i]) {
                sum += nums[i + 1];
                i++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
