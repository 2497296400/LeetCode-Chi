package 周赛.三百零八.从字符串中移除星号;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leet**cod*e";
        System.out.println(solution.removeStars(s));
    }

    public String removeStars(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '*'&&!stack.isEmpty()) {
               stack.pop();
            }else {
                stack.push(array[i]);
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return String.valueOf(stringBuilder);
    }
}


