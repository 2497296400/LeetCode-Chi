package 括号问题.括号的分数;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(())()";
        System.out.println(solution.fun(s.toCharArray(),0).ans);
    }

    public int scoreOfParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        char[] chars = s.toCharArray();
        boolean flag = false;

        for (char aChar : chars) {
            if (aChar == '(') {
                stack.add(aChar);
                flag = true;
            } else {
                if (flag) {
                    ans += Math.pow(2, stack.size() - 1);
                    flag = false;
                }
                stack.pop();
            }
        }
        return ans;
    }



    public int process(String s) {
        if (s.length() == 2) {
            return 1;
        }
        int len = 0;
        int flag = 0;
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            flag = s.charAt(i) == '(' ? flag + 1 : flag - 1;
            if (flag == 0) {
                len = i + 1;
                break;
            }
        }
        int ans = 0;
        if (len == s.length()) {
            ans = 2 * process(s.substring(1, n - 1));
        } else {
            ans = process(s.substring(0, len)) + process(s.substring(len));
        }
        return ans;
    }

    public info fun(char[] chars, int i) {
        int base = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < chars.length && chars[i] != ')') {
            stack.push(1);
            info info = fun(chars, i + 1);
            i = info.index + 1;
            base = info.ans;
        }
        toCheck(stack, base);
        return new info(getAns(stack), i);
    }

    private int getAns(Stack<Integer> stack) {
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop() * 2;
        }
        return sum;
    }

    private void toCheck(Stack<Integer> stack, int base) {
        while (!stack.isEmpty()) {
            base += stack.pop();
        }
        stack.push(base);
    }
}

class info {
    int ans;
    int index;

    public info(int ans, int index) {
        this.ans = ans;
        this.index = index;
    }
}