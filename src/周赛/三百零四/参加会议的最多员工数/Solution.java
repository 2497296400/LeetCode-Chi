package 周赛.三百零四.参加会议的最多员工数;

import java.util.*;

public class Solution {
    List<Integer>[] secondGraph;
    int[] deg;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums={2,2,1,2};
        System.out.println(solution.maximumInvitations(nums));
    }

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        secondGraph = new List[n];
        for (int i = 0; i < n; i++) {
            secondGraph[i] = new ArrayList<>();
        }
        deg = new int[n];
        for (int i = 0; i < n; i++) {
            int next = favorite[i];
            secondGraph[next].add(i);
            deg[next]++;
        }
        Queue<Integer> zeroQuene = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                zeroQuene.add(i);
            }
        }
        while (!zeroQuene.isEmpty()) {
            Integer curNode = zeroQuene.poll();
            int next = favorite[curNode];
            deg[next]--;
            if (deg[next] == 0) {
                zeroQuene.add(next);
            }
        }
        int maxRingSize = 0, sumChainSize = 0;
        for (int i = 0; i < n; i++) {
            if (deg[i] <= 0) {
                continue;
            }
            deg[i] = -1;
            int ringSize = 1;
            for (int j = favorite[i]; j != i; j = favorite[j]) {
                deg[j] = -1;
                ringSize++;
            }
            if (ringSize == 2) {
                sumChainSize += dfs(i) + dfs(favorite[i]);
            } else {
                maxRingSize = Math.max(maxRingSize, ringSize);
            }
        }
        return Math.max(sumChainSize, maxRingSize);
    }

    private int dfs(int i) {
        int maxDepth = 1;
        for (Integer cur : secondGraph[i]) {
            if (deg[cur] == 0) {
                maxDepth = Math.max(maxDepth, dfs(cur) + 1);
            }
        }
        return maxDepth;
    }
}
