package 灵神总结周赛.数据结构.单调栈;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 3, 9, 5, 1, 10, 0};
        Solution solution = new Solution();
        int[][] otherMin = solution.getOtherMin(arr);
        System.out.println(Arrays.deepToString(otherMin));
    }

    public int[][] getOtherMin(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], -1);
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int tar = stack.pop();
                ans[tar][1] = arr[i];
                int l = stack.isEmpty() ? -1 : arr[stack.peek()];
                ans[tar][0] = l;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer integer = stack.pop();
            ans[integer][1] = -1;
            int l = stack.isEmpty() ? -1 : arr[stack.peek()];
            ans[integer][0] = l;
        }
        return ans;
    }
}
