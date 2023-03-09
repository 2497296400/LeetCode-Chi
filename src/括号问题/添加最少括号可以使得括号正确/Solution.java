package 括号问题.添加最少括号可以使得括号正确;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "([([)";
        System.out.println(solution.brackets(s));
    }

    public int brackets(String str) {

        char[] chars = str.toCharArray();
        return fun(chars, 0, chars.length - 1);
    }
    private int fun(char[] chars, int L, int R) {
        if (L == R) {
            return 1;
        }
        if (L == R - 1) {
            if ((chars[L] == '(' && chars[R] == ')')
                    || (chars[L] == '[' && chars[R] == ']')) {
                return 0;
            } else {
                return 2;
            }
        }
        int p1 = Integer.MAX_VALUE;
        int pLast1 = fun(chars, L + 1, R) + 1;
        int pLast2 = fun(chars, L, R - 1) + 1;

        if ((chars[L] == '(' && chars[R] == ')')
                || (chars[L] == '[' && chars[R] == ']')) {
            p1 = fun(chars, L + 1, R - 1);
        }
        p1 = Math.min(p1, Math.min(pLast1, pLast2));
        int p2=Integer.MAX_VALUE;
        for (int mid = L; mid < R; mid++) {
            p2 = Math.min(p2,
                    (fun(chars, L, mid)+
                            fun(chars, mid + 1, R)));
        }
        return Math.min(p1, p2);
    }
}
