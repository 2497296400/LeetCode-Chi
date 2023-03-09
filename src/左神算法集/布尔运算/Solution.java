package 左神算法集.布尔运算;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "0&0&0&1^1|0";
        System.out.println(solution.countEval(s, 1));

    }

    public int countEval(String s, int result) {
        char[] chars = s.toCharArray();
        info[][] dp = new info[chars.length][chars.length];
        info all = fun(chars, 0, chars.length - 1, dp);
        return result == 1 ? all.t : all.f;
    }

    private info fun(char[] chars, int L, int R, info[][] dp) {
        if (dp[L][R] != null) {
            return dp[L][R];
        }
        int ts = 0;
        int fs = 0;
        if (L == R) {
            ts = chars[L] == '1' ? 1 : 0;
            fs = chars[L] == '0' ? 1 : 0;
        } else {
            for (int cur = L + 1; cur < R; cur += 2) {
                info leftInfo= fun(chars, L, cur - 1, dp);
                info rightInfo = fun(chars, cur + 1, R, dp);
                int a = leftInfo.t;
                int b = leftInfo.f;
                int c = rightInfo.t;
                int d = rightInfo.f;
                if (chars[cur] == '&') {
                    ts+= a * c;
                    fs += b * c + b * d + a * d;
                } else if (chars[cur] == '|') {
                    ts += a * c + a * d + b * c;
                    fs += b * d;
                } else if (chars[cur] == '^') {
                    ts+= a * d + b * c;
                    fs+= a * c + b * d;
                }
            }
        }
        dp[L][R] = new info(ts, fs);
        return dp[L][R];
    }

}

class info {
    int t;
    int f;

    public info(int t, int f) {
        this.t = t;
        this.f = f;
    }
}
