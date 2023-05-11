package 每日一题系列.每日一题四月.按字典序排在最后的子串;

public class 双指针 {
    public String lastSubstring(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int l = 0, r = 1;
        while (r < n) {
            int k = 0;
            while (l + k < n && chars[l + k] == chars[r + k]) {
                k++;
            }
            if (r + k < n && chars[l + k] < chars[r + k]) {
                int t = l;
                l = r;
                r = Math.max(r + 1, t + k + 1);
            } else {
                r = r + k + 1;
            }
        }
        return s.substring(l);
    }
}
