package 括号问题.计算字符串;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String s = "5-3";
        Test test = new Test();
        System.out.println(test.calculate(s));
    }

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        return fun(chars, 0).cur;
    }

    private Info fun(char[] chars, int index) {
        int base = 0;
        Info cur;
        Stack<String> stack = new Stack<>();
        while (index < chars.length && chars[index] != ')') {
            if (Character.isDigit(chars[index])) {
                base = base * 10 + chars[index++] - '0';
            } else if (chars[index] != '(') {
                toCheck(stack, base);
                stack.push(String.valueOf(chars[index++]));
                base = 0;
            } else {
                cur = fun(chars, index + 1);
                base = cur.cur;
                index = cur.index + 1;
            }
        }
        toCheck(stack, base);
        return new Info(getSum(stack), index);
    }

    private int getSum(Stack<String> stack) {
        while (stack.size() >= 3) {
            String firstData = stack.pop();
            String operator = stack.pop();
            String secondData = stack.pop();
            int f = Integer.parseInt(firstData);
            int s = Integer.parseInt(secondData);
            f = operator.equals("+") ? f + s : s - f;
            stack.push(String.valueOf(f));
        }
        return Integer.parseInt(stack.pop());
    }

    private void toCheck(Stack<String> stack, int base) {
        if (!stack.isEmpty()) {
            String cur = stack.pop();
            if (cur.equals("+") || cur.equals("-")) {
                stack.push(cur);
            } else {
                String curData = stack.pop();
                int parseInt = Integer.parseInt(curData);
                base = cur.equals("*") ? parseInt * base : parseInt / base;
            }
        }
        stack.push(String.valueOf(base));
    }
}
