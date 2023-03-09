package 周赛.三百二十八场.第二题差分和前缀和;

import java.util.Arrays;

//差分 + 前缀和 = 原数组
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] q = {{1, 1, 2, 2}, {0, 0, 1, 1}};
        System.out.println(Arrays.deepToString(solution.rangeAddQueries2(3, q)));
    }

    // 一维差分
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] grip = new int[n][n];
        for (int[] query : queries) {
            int c1 = query[0];
            int r1 = query[1];
            int c2 = query[2];
            int r2 = query[3];
            while (c1 <= c2) {
                grip[c1][r1] += 1;
                if (r2 + 1 < n) {
                    grip[c1][r2 + 1] -= 1;
                }
                c1++;
            }
        }

        for (int[] ints : grip) {
            for (int i = 1; i < n; i++) {
                ints[i] += ints[i - 1];
            }
        }
        return grip;
    }

    public int[][] rangeAddQueries2(int n, int[][] queries) {
        int[][] grip = new int[n + 1][n + 1];
        for (int[] query : queries) {
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2] + 1;
            int c2 = query[3] + 1;
            grip[r1][c1] += 1;
            grip[r1][c2] -= 1;
            grip[r2][c1] -= 1;
            grip[r2][c2] += 1;
        }
        int[][] ans = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i + 1][j + 1] = ans[i + 1][j] + ans[i][j + 1] - ans[i][j] + grip[i][j];
            }
        }
        int[][] curAns = new int[n][n];
        for (int i = 1; i <= n; i++) {
            System.arraycopy(ans[i], 1, curAns[i - 1], 0, n);
        }
        return curAns;
    }
}