package 基础数据结构.单调栈.一三二模式;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {};
        Solution solution = new Solution();
        System.out.println(solution.find132pattern(arr));
    }

    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int curMin = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < curMin) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                curMin = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
