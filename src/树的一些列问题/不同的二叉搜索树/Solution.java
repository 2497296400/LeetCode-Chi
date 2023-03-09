package 树的一些列问题.不同的二叉搜索树;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numsTreesDp(99));
        System.out.println(numTrees(99));
    }
    static Map<Integer, Integer> map = new HashMap<>();
    public static int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftnum = numTrees(i - 1);
            int rightnum = numTrees(n - i);
            count += leftnum * rightnum;
        }
        map.put(n, count);
        return count;
    }
    public static int numsTreesDp(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
