package 每日一题系列.每日一题八月.分割字符串的最大得分;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "1111";
        System.out.println(solution.maxScore(s));
    }

    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int[] startZero = new int[chars.length];
        int[] endOne = new int[chars.length];
        int n = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                startZero[i] = chars[i] == '0' ? 1 : 0;
                endOne[n - i] = chars[n - i] == '1' ? 1 : 0;
            } else {
                startZero[i] = startZero[i - 1] + (chars[i] == '0' ? 1 : 0);
                endOne[n - i] = endOne[n - i + 1] + (chars[n - i] == '1' ? 1 : 0);
            }
        }
        startZero[n] = 0;
        endOne[0] = 0;
        int max = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            max = Math.max(startZero[i] + endOne[i + 1], max);
        }
        return max;
    }
}
