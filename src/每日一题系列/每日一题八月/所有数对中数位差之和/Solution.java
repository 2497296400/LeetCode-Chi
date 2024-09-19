package 每日一题系列.每日一题八月.所有数对中数位差之和;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {50, 28, 48};
        System.out.println(solution.sumDigitDifferences(nums));
    }

    public long sumDigitDifferences(int[] nums) {
        int len = nums.length;
        int weigh = 0;
        int target = nums[0];
        while (target != 0) {
            weigh++;
            target = target / 10;
        }
        int sum = 0;
        for (int i = 0; i < weigh; i++) {
            int[] temp = new int[10];
            for (int j = 0; j < len; j++) {
                int p = nums[j] % 10;
                temp[p]++;
                nums[j] = nums[j] / 10;
            }
            for (int k = 0; k < 10; k++) {
                for (int j = k + 1; j < 10; j++) {
                    sum += (long) temp[k] * temp[j];
                }
            }
        }
        return sum;
    }
}
