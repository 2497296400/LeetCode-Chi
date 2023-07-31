package 括号问题.计算字符串;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String s = "5-3*(5+5)*100";
        Test test = new Test();
        System.out.println(test.calculate(s));
    }

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for (char aChar : chars) {
            queue.add(aChar);
        }
        return fun(queue);
    }

    private int fun(Queue<Character> queue) {
        Stack<Integer> stack = new Stack<>();
        int base = 0;
        char sign = '+';
        while (queue.size() > 0) {
            Character poll = queue.poll();
            if (Character.isDigit(poll)) {
                base = base * 10 + poll - '0';
            }
            if (poll == '(') {
                base = fun(queue);
            }
            if (!Character.isDigit(poll) || queue.size() == 0) {
                if (sign == '+') {
                    stack.push(base);
                } else if (sign == '-') {
                    stack.push(-base);
                } else if (sign == '*') {
                    stack.push(stack.pop() * base);
                } else if (sign == '/') {
                    stack.push(stack.pop() / base);
                }
                sign = poll;
                base = 0;
            }
            if (poll == ')') break;
        }
        return getSum(stack);
    }

    private int getSum(Stack<Integer> stack) {
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}