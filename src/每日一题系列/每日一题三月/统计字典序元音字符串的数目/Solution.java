package 每日一题系列.每日一题三月.统计字典序元音字符串的数目;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countVowelStrings(33));
    }

    List<List<Character>> cur = new ArrayList<>();

    public int countVowelStrings(int n) {

        char[] arr = {'a', 'e', 'i', 'o', 'u'};
        int a = fun(arr, n, 0,  new Stack<Character>());
        System.out.println(cur);
        return a;
    }

    private int fun(char[] arr, int n, int pre,Stack<Character> characters) {
        if (n == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i >= pre) {
                ans += fun(arr, n - 1, i,  characters);
            }
        }
        return ans;
    }
}
