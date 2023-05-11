package 回文字符串系列.最长回文子串;

public class Test {
    int strat = 0;
    int end = 0;

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        fun(chars, 0);
        return s.substring(strat, end+1);
    }

    private void fun(char[] chars, int cur) {
        if (cur >= chars.length - 1 || (chars.length - cur) * 2 < (end - strat)) {
            return;
        }
        int curStrat = cur;
        int curEnd = cur;
        while (curEnd < chars.length - 1 && chars[curEnd] == chars[curEnd + 1]) {
            curEnd++;
        }
        cur = curEnd;
        while (curStrat > 0 && curEnd < chars.length - 1 && chars[curStrat - 1] == chars[curEnd + 1]) {
            curEnd++;
            curStrat--;
        }
        if ((curEnd - curStrat) > (end - strat)) {
            end = curEnd;
            strat = curStrat;
        }
        fun(chars, cur + 1);
    }
}
