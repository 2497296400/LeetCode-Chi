package 动态规划问题.最长无重复子串;

public class Solution2 {
    public String longestNonRepeatingSubstring(String str) {
        int start = 0;
        int end = 0;
        int l = 0, r = 0;
        int[] ch = new int[26];
        while (r < str.length()) {
            ch[str.charAt(r++)-'a']++;
            while (ch[str.charAt(r - 1)-'a'] > 1 && l < r) {
                ch[str.charAt(l++)-'a']--;
            }
            if (r - l > end - start) {
                start = l;
                end = r;
              //  System.out.println(str.substring(start, end));
            }
        }
        return str.substring(start, end);
    }
}
