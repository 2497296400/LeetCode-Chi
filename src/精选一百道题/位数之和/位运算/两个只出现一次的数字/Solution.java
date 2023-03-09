package 精选一百道题.位数之和.位运算.两个只出现一次的数字;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4};
        find(nums);
    }
    public static void find(int[] nums) {
        int cur = 0;
        int onlyOne = 0;
        for (int num : nums) {
            cur ^= num;
        }
        int rightOne = cur & (~cur + 1);
        for (int num : nums) {
            if ((num& rightOne) == 1) {
                onlyOne ^= num;
            }
        }
        System.out.println(onlyOne + " " + (cur ^ onlyOne));
    }
}
