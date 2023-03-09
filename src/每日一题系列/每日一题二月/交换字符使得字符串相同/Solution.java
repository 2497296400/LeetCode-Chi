package 每日一题系列.每日一题二月.交换字符使得字符串相同;

public class Solution {
    public int minimumSwap(String s1, String s2) {
        char[] cf = s1.toCharArray();
        char[] cs = s2.toCharArray();
        int xsumf = 0;
        int ysumf = 0;
        int xsums = 0;
        int ysums = 0;

        if (cf.length != cs.length) {
            return -1;
        }
        for (char c : cf) {
            if (c == 'x') {
                xsumf++;
            } else {
                ysumf++;
            }
        }
        for (char c : cs) {
            if (c == 'x') {
                xsums++;
            } else {
                ysums++;
            }
        }
        if ((xsums + xsumf) % 2 != 0 || (ysumf + ysums) % 2 != 0) {
            return -1;
        }
        int f = 0;
        int s = 0;
        for (int i = 0; i < cf.length; i++) {
            if (cf[i] != cs[i]) {
                if (cf[i] == 'x') {
                    f++;
                } else {
                    s++;
                }
            }
        }
        int sum = f / 2 + s / 2;
        if (f % 2 != 0) {
            sum += 2;
        }
        return sum;
    }
}
