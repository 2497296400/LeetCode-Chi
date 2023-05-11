package 灵神总结周赛.数据结构.元素值大于变化阈值的子数组;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 4, 3, 1};
        System.out.println(solution.validSubarraySize(arr, 6));
    }

    public int validSubarraySize(int[] nums, int threshold) {
        Stack<Integer> stack = new Stack<>();
        int[][] d = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                int ta = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                d[ta][0] = left;
                d[ta][1] = i;
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            int ta = stack.pop();
            int left = stack.isEmpty() ?-1 : stack.peek();
            d[ta][0] = left;
            d[ta][1] = nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            int k = (d[i][1] - d[i][0])-1;
            if (nums[i] > threshold / k) {
                return k;
            }
        }
        return -1;
    }
}
