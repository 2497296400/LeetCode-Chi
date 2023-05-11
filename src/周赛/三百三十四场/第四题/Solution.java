package 周赛.三百三十四场.第四题;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestBeautifulString("abcz", 26));
    }

    public String smallestBeautifulString(String s, int k) {
        int temp = k + 'a';
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = n - 1;
        chars[i]++;
        while (i >= 0 && i < n) {
            if (chars[i] == temp) {
                if (i == 0) {
                    return "";
                }
                chars[i] = 'a';
                chars[--i]++;
            } else if (i > 0 && chars[i] == chars[i - 1] || (i > 1 && chars[i] == chars[i - 2])) {
                chars[i]++;
            } else {
                i++;
            }
        }
        return String.valueOf(chars);
    }
}
