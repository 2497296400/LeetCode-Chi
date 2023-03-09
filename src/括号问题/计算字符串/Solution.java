package 括号问题.计算字符串;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "4+5+5*(6-1)";

        char[] chars = s.toCharArray();
        System.out.println(getAns(chars));
    }

    private static int getAns(char[] chars) {
        int ans;
        ans = process(chars, 0).cur;
        return ans;
    }
    private static Info process(char[] chars, int i) {
        Stack<String> stack = new Stack<>();
        Info curData;
        int base = 0;
        //寻找当前位置
        while (i < chars.length && chars[i] != ')') {
            if (chars[i] >= '0' && chars[i] <= '9') {
                base = base * 10 + chars[i++] - '0';
            } else if (chars[i] != '(') {
                addStack(stack, base);
                stack.push(String.valueOf(chars[i++]));
                base = 0;
            } else {
                curData = process(chars, i + 1);
                base = curData.cur;
                i = curData.index + 1;
            }
        }
        addStack(stack, base);
        return new Info(getSum(stack), i);
    }

    private static int getSum(Stack<String> stack) {
        while (stack.size() >= 3) {
            String num1 = stack.pop();
            String str = stack.pop();
            String num2 = stack.pop();
            int tempans = "+".equals(str) ? Integer.parseInt(num1) + Integer.parseInt(num2) : Integer.parseInt(num2) - Integer.parseInt(num1);
            stack.push(String.valueOf(tempans));
        }
        return Integer.parseInt(stack.peek());
    }

    private static void addStack(Stack<String> stack, int base) {
        if (!stack.isEmpty()) {
            String str = stack.pop();
            if ("+".equals(str) || "-".equals(str)) {
                stack.push(str);
            } else {
                base = "*".equals(str) ? (base * Integer.parseInt(stack.pop())) : (base / Integer.parseInt(stack.pop()));
            }
        }
        stack.push(String.valueOf(base));
    }
}

class Info {
    int cur;
    int index;

    public Info() {
    }

    public Info(int cur, int index) {
        this.cur = cur;
        this.index = index;
    }
}
