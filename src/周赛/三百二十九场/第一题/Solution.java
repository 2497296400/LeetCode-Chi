package 周赛.三百二十九场.第一题;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.alternateDigitSum(10));
    }

    public int alternateDigitSum(int n) {
        int ans = 0;
        int temp = 1;
        Stack<Integer> stack = new Stack<>();

        while (n != 0) {
            stack.add(n % 10);
            n /= 10;
        }
        while (!stack.isEmpty()) {
            ans += stack.pop() * temp;
            temp*=-1;
        }
        return ans;
    }
}
