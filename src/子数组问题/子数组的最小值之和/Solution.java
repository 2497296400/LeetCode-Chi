package 子数组问题.子数组的最小值之和;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 1, 2, 4};
        System.out.println(solution.sumSubarrayMins(arr));
        System.out.println(solution.sumSubarrayMins2(arr));
    }

    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int MOD = (int) (1e9 + 7);
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        Stack<Integer> l = new Stack<>();
        Stack<Integer> r = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!l.isEmpty() && arr[l.peek()] >= arr[i]) {
                l.pop();
            }
            left[i] = l.isEmpty() ? -1 : l.peek();
            l.push(i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!r.isEmpty() && arr[r.peek()] > arr[i]) {
                r.pop();
            }
            right[i] = r.isEmpty() ? arr.length : r.peek();
            r.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            sum += (long) (i - left[i]) * (right[i] - i) * arr[i];
        }
        return (int) (sum % MOD);
    }

    public int sumSubarrayMins2(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> str = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!str.isEmpty() && arr[str.peek()] > arr[i]) {
                int cur = str.pop();
                int leftLessIndex = str.isEmpty() ? -1 : str.peek();
                res[cur][0] = leftLessIndex;
                res[cur][1] = i;
            }
            str.push(i);
        }
        int MOD = (int) (1e9 + 7);
        while (!str.isEmpty()) {
            int popIndex = str.pop();  // 弹出栈顶元素
            int leftLessIndex = str.isEmpty() ? -1 : str.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = arr.length;
        }
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (long) (i - res[i][0]) * (res[i][1] - i) * arr[i];
        }
        return (int )sum%MOD;
    }
}
