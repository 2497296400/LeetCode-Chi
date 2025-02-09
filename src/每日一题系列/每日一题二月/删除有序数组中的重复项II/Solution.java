package 每日一题系列.每日一题二月.删除有序数组中的重复项II;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(solution.removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
