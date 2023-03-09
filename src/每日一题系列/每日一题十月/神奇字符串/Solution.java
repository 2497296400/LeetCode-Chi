package 每日一题系列.每日一题十月.神奇字符串;

public class Solution {
    public int magicalString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("122");
        if (n < 2) {
            return 1;
        }
        boolean falg = false;
        for (int i = 2; i <= n; i++) {
            int  charAt = stringBuilder.charAt(i)-'0';
            if (!falg) {
                stringBuilder.append("1".repeat(charAt));
                falg = true;
            } else {
                falg = false;
                stringBuilder.append("2".repeat(charAt));
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (stringBuilder.charAt(i) == '1') {
                ans++;
            }
        }
        return ans;
    }
}