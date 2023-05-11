package 灵神总结周赛.数据结构.下一个更大元素IV;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int []ar = new int[]{2,4,0,9,6};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.secondGreaterElement(ar)));
    }
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> p1 = new Stack<>();
        Stack<Integer> p2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!p2.isEmpty() && nums[p2.peek()] < nums[i]) {
                ans[p2.pop()] = nums[i];
            }
            Stack<Integer> temp = new Stack<>();
            while (!p1.isEmpty() && nums[p1.peek()] < nums[i]) {
                temp.push(p1.pop());
            }
            while (!temp.isEmpty()) {
                p2.push(temp.pop());
            }
            p1.push(i);
        }
        return ans;
    }
}
