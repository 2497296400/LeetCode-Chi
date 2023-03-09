package 基础数据结构.单调栈.柱状图中最大的矩形;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 3};
        System.out.println(largestRectangleArea1(nums));
    }

    //暴力解法
    public static int largestRectangleArea(int[] heights) {
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                ans = Math.max(ans, (j - i + 1) * findMin(heights, i, j));
            }
        }
        return ans;

    }

    private static int findMin(int[] heights, int start, int end) {
        int min = heights[start];
        for (int i = start; i <= end; i++) {
            if (heights[i] < min) {
                min = heights[i];
            }
        }
        return min;
    }

    //单调栈
    public static int largestRectangleArea1(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                ans = Math.max(ans, width * height);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width;
            if (stack.isEmpty()) {
                width = heights.length;
            } else {
                width = heights.length - stack.peek() - 1;

            }
            ans = Math.max(ans, width * height);
        }
        return ans;
    }
}
