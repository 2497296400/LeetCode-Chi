package 每日一题系列.每日一题三月.最大网络秩;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{8, 12}, {5, 11}, {5, 12}, {9, 4}, {0, 9}, {1, 8}, {10, 2}, {13, 14}, {3, 4}, {11, 3}, {11, 8}, {5, 10}};
        System.out.println(solution.maximalNetworkRank(15, arr));
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        Set[] grap = new Set[n];

        for (int i = 0; i < n; i++) {
            grap[i] = new HashSet<Integer>();
        }
        int max = 0;
        int maxN = 0;
        for (int[] road : roads) {
            grap[road[0]].add(road[1]);
            grap[road[1]].add(road[0]);
            if (max < grap[road[0]].size()) {
                max = grap[road[0]].size();
                maxN = road[0];
            }
            if (max < grap[road[1]].size()) {
                max = grap[road[1]].size();
                maxN = road[1];
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (grap[j].size() == max) {
                for (int i = 0; i < n; i++) {
                    if (i != j) {
                        ans = Math.max(ans, max + (grap[i].contains(j) ? grap[i].size() - 1 : grap[i].size()));
                    }
                }
            }
        }
        return ans;
    }
}
