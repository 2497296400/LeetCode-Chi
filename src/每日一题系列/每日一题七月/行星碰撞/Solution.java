package 每日一题系列.每日一题七月.行星碰撞;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(nums)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean isA = true;
            while (!stack.isEmpty() && isA && stack.peek() > 0 && asteroid < 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();
                } else {
                    if (stack.peek() == -asteroid) {
                        stack.pop();
                    }
                    isA = false;
                }
            }
            if (isA) {
                stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        int index = ans.length - 1;
        while (!stack.isEmpty()) {
            ans[index--] = stack.pop();
        }
        return ans;
    }
}