package 动态规划难搞类.合并石头的最低成本;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 2, 4, 1};
        System.out.println(solution.mergeStones(arr, 4));
    }
    public int mergeStones(int[] stones, int k) {
        int[][][] dp = new int[stones.length][stones.length][k + 1];
        int[] presum = new int[stones.length + 1];
        if ((stones.length - 1) % (k - 1) != 0) {
            return -1;
        }
        for (int i = 0; i < stones.length; i++) {
            presum[i + 1] = presum[i] + stones[i];
        }
          int fun = fun(0, stones.length - 1, k, 1, presum, dp);
        System.out.println(fun);
        return process2(0, stones.length - 1, 1, k, presum, dp);


    }

    private int fun(int left, int right, int k, int p, int[] presum, int[][][] dp) {
        if (left == right) {
            return p == 1 ? 0 : -1;
        }
        
        if (p == 1) {
            int next = fun(left, right, k, k, presum, dp);
            if (next == -1) {
                return -1;
            } else {
                return next + presum[right + 1] - presum[left];
            }
        } else {
            int curMin = Integer.MAX_VALUE;
            // 枚举分界点
            for (int cur = left; cur < right; cur += k - 1) {
                // 左边的合并成1堆，右边的合并成p-1堆
                int p1 = fun(left, cur, k, 1, presum, dp);
                int p2 = fun(cur + 1, right, k, p - 1, presum, dp);
                if (p1 == -1 || p2 == -1) {
                    return -1;
                } else {
                    curMin = Math.min(curMin, p1 + p2);
                }
            }
            return curMin;
        }
    }
    public static int process2(int L, int R, int P, int K, int[] presum, int[][][] dp) {
        if (dp[L][R][P] != 0) {
            return dp[L][R][P];
        }
        if (L == R) {
            return P == 1 ? 0 : -1;
        }
        if (P == 1) {
            int next = process2(L, R, K, K, presum, dp);
            if (next == -1) {
                dp[L][R][P] = -1;
                return -1;
            } else {
                dp[L][R][P] = next + presum[R + 1] - presum[L];
                return next + presum[R + 1] - presum[L];
            }
        } else {
            int ans = Integer.MAX_VALUE;
            // i...mid是第1块，剩下的是part-1块
            for (int mid = L; mid < R; mid ++) {
                int next1 = process2(L, mid, 1, K, presum, dp);
                int next2 = process2(mid + 1, R, P - 1, K, presum, dp);
                if (next1 == -1 || next2 == -1) {
                    dp[L][R][P] = -1;
                    return -1;
                } else {
                    ans = Math.min(ans, next1 + next2);
                }
            }
            //dp[L][R][P] = ans;
            return ans;
        }
    }

}
