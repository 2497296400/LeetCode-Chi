package 回文字符串系列.回文子串;

public class Solution {
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(countSubstrings(s));
        System.out.println(countSubstrings2(s));
    }

    static int num = 0;

    public static int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);//回文串长度为奇数
            count(s, i, i + 1);//回文串长度为偶数
        }
        return num;
    }

    public static void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            start--;
            end++;
        }
    }

    public static int countSubstrings2(String s) {
        for (int i = 0; i < s.length() * 2 - 1; i++) {
            int l = i / 2, r = l+ i % 2;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                num++;
                l--;
                r++;
            }
        }
        return num;
    }
}

