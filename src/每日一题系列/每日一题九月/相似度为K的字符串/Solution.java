package 每日一题系列.每日一题九月.相似度为K的字符串;

public class Solution {
    public int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "abc";
        String s2 = "bca";
        System.out.println(solution.kSimilarity(s1, s2));
    }

    public int kSimilarity(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        dfs(c1, c2, 0, c1.length, 0);
        return ans;
    }

    private void dfs(char[] c1, char[] c2, int cur, int length, int min) {
        if (cur == length) {
            ans = Math.min(ans, min);
            return;
        }
        if (c1[cur] != c2[cur]) {
            for (int i = cur + 1; i < length; i++) {
                if (c1[cur] == c2[i]) {
                    swap(c2, cur, i);
                    dfs(c1, c2, cur + 1, length, min + 1);
                    swap(c2, cur, i);
                }
            }
        } else {
            dfs(c1, c2, cur + 1, length, min);
        }
    }

    private void swap(char[] c1, int cur, int i) {
        char temp = c1[cur];
        c1[cur] = c1[i];
        c1[i] = temp;
    }
}
