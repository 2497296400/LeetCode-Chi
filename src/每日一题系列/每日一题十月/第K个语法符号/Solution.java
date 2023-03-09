package 每日一题系列.每日一题十月.第K个语法符号;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthGrammar(3, 4));
    }

    public int kthGrammar(int n, int k) {
        if (k == 1 || n == 1) {
            return 0;
        }
        if (k > Math.pow(2, n - 1)) {
            return getR(kthGrammar(n - 1, (int) (k - Math.pow(2, n - 1))));
        } else if (k == Math.pow(2, n - 1)) {
            return getR(kthGrammar(n - 1, k));
        } else {
            return kthGrammar(n - 1, k);
        }
    }

    private int getR(int kthGrammar) {
        return kthGrammar == 0 ? 1 : 0;
    }
}
