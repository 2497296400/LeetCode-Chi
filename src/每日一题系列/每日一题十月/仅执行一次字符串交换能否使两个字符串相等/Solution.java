package 每日一题系列.每日一题十月.仅执行一次字符串交换能否使两个字符串相等;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1="bank";
        String s2="kanb";
        System.out.println(solution.areAlmostEqual(s1, s2));
    }
    public boolean areAlmostEqual(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char first = 0;
        char second = 0;
        int sum = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c2[i] != c1[i] && sum == 0) {
                first = c1[i];
                second = c2[i];
                sum++;
                continue;
            }
            if (c2[i] != c1[i] && sum == 1) {
                if (first != c2[i] || second != c1[i]) {
                    return false;
                }
                sum++;
                continue;
            }
            if (c2[i] != c1[i] && sum > 1) {
                return false;
            }
        }
        return sum==2||sum==0;
    }
}
