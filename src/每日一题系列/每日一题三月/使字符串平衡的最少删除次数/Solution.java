package 每日一题系列.每日一题三月.使字符串平衡的最少删除次数;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDeletions("aababbab"));
    }
    public int minimumDeletions(String s) {
        char[] chars = s.toCharArray();
        int strat = 0;
        int end = chars.length - 1;
        int[] preA = new int[chars.length];
        preA[0] = chars[0] == 'a' ? 1 : 0;
        int[] lastB = new int[chars.length];
        lastB[chars.length - 1] = chars[chars.length - 1] == 'b' ? 1 : 0;

        for (int i = 1; i < chars.length; i++) {
            preA[i] = preA[i - 1] + (chars[i] == 'a' ? 1 : 0);
        }
        for (int i = chars.length - 2; i >= 0; i--) {
            lastB[i] = lastB[i + 1] + (chars[i] == 'b' ? 1 : 0);
        }
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            curMax = Math.max(curMax, preA[i] + lastB[i]);
        }
        return s.length() - curMax;
    }
}
