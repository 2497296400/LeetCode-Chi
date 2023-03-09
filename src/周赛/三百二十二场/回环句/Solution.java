package 周赛.三百二十二场.回环句;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isCircularSentence("leetcode exercises sound delightful"));
    }
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        if (s[0].charAt(0) != s[s.length - 1].charAt(s[s.length - 1].length() - 1)) {
            return false;
        }
        for (int i = 0; i < s.length - 1; i++) {
            if (!toCheck(s[i], s[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean toCheck(String s, String s1) {
        return s.charAt(s.length() - 1) == s1.charAt(0);
    }
}
