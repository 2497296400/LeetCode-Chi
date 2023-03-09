package 每日一题系列.每日一题十一月.解析布尔表达式;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
//        "&(|(f))"
//        "|(f,f,f,t)"
//        "!(&(f,t))"
        Solution solution = new Solution();
        System.out.println(solution.parseBoolExpr("&(|(f))"));
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] chars = expression.toCharArray();
        Stack<Character> pre = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '&' || chars[i] == '|' || chars[i] == '!') {
                pre.push(chars[i]);
            } else if (chars[i] != ')') {
                stack.push(chars[i]);
            } else {
                toCherck(stack, pre);
            }
        }
        return stack.pop() == 't';
    }

    private void toCherck(Stack<Character> stack, Stack<Character> pre) {
        char b = pre.pop();
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            Character pop = stack.pop();
            if (pop != '(') {
                stringBuilder.append(pop);
            } else {
                break;
            }
        }
        if (b == '&') {
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == 'f') {
                    stack.push('f');
                    return;
                }
            }
            stack.push('t');
        } else if (b == '|') {
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == 't') {
                    stack.push('t');
                    return;
                }
            }
            stack.push('f');
        } else {
            stack.push(stringBuilder.charAt(0) == 't' ? 'f' : 't');
        }
    }
}