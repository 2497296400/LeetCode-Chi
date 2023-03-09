package 周赛.三百二十五自己傻逼场.第一题;

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"hello", "i", "am", "leetcode", "hello"};
        String ta = "hello";
        System.out.println(solution.closetTarget(strings, ta, 1));
    }

    public int closetTarget(String[] words, String target, int startIndex) {
        int curIndex = startIndex;
        int ans = Integer.MAX_VALUE;
        for (int i = curIndex; ; ) {
            if (Objects.equals(words[i], target)) {
                ans = Math.min(ans, Math.min(words.length - Math.abs(i - startIndex), Math.abs(i - startIndex)));
            }
            if ((i = ((i + 1) % words.length)) == startIndex) {
                return ans == Integer.MAX_VALUE ? -1 : ans;
            }
        }
    }
}
