package Top集合.最长回文字串;

public class Solution {
    public static void main(String[] args) {
        String f = "aabbaacad";
        int start = 0, end = 0;
        for (int i = 1; i < f.length() * 2 - 1; i++) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < f.length() && f.charAt(l) == f.charAt(r)) {
                l--;
                r++;
            }
            if (r - l - 1 > end - start) {
                start = l + 1;
                end = r;
            }
        }
        System.out.println(f.substring(start, end));
    }
}
