package 基础数据结构.单调栈.下一个更大元素II;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(solution.nextGreaterElements(arr)));
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                Integer cur = stack.pop();
                ans[cur] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > nums[stack.peek()]) {
                Integer cur = stack.pop();
                ans[cur] = nums[i];
            }
        }
        return ans;
    }
}
