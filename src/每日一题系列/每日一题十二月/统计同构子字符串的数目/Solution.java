package 每日一题系列.每日一题十二月.统计同构子字符串的数目;

public class Solution {
    final int MOD = (int) (1e9 + 7);

    public int countHomogenous(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;
        long ans = 0L;
        while (r < chars.length) {
            int len = 1;
            char pre = chars[r];
            while (pre == chars[r++]) {
                ans += len++;
            }
        }
        return (int) (ans % MOD);
    }
}
