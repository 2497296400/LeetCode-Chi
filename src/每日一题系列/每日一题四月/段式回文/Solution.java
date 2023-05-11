package 每日一题系列.每日一题四月.段式回文;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestDecomposition("antaprezatepzapreanta"));
    }

    public int longestDecomposition(String text) {
        int sum = 0;
        int l = 0, r = text.length();

        while (l < r) {
            int target = 0;
            for (int i = l; i < r; i++) {
                String sub = text.substring(l, i + 1);
                int next = text.lastIndexOf(sub) + sub.length();
                if (next == r) {
                    r = r - sub.length();
                    l = l + sub.length();
                    text = text.substring(0, r);
                    sum += l < r ? 2 : 1;
                    target = 1;
                    break;
                }
            }
            if (target == 0) {
                return sum + 1;
            }
        }
        return sum;
    }
}
