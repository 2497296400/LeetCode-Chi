package 每日一题系列.二零二三年七月.两数之和;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();


        int[] nums = {3, 24, 50, 79, 88, 150, 345};
        int target = 167;
        int[] ans = solution.twoSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int l = 0, r = 1;
        int last = 0;
        while (l < numbers.length) {
            if (numbers[l] + numbers[r] == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            } else if (r < numbers.length && numbers[l] + numbers[r] < target) {
                if (r == numbers.length - 1 || last != 0) {
                    l++;
                } else {
                    r++;
                }
            } else {
                r--;
                last = r;
            }
        }
        return ans;
    }
}
