package 深度广度遍历问题.括号排列;

import java.util.ArrayList;
import java.util.List;
class Solution {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(10));
    }

    static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        getParenthesis("", n, n);
        return res;
    }


    private static void getParenthesis(String str, int left, int right) {
        if (right < left || right < 0 || left < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        getParenthesis(str + "(", left - 1, right);
        getParenthesis(str + ")", left, right - 1);
    }
}

