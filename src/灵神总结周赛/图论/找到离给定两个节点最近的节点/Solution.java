package 灵神总结周赛.图论.找到离给定两个节点最近的节点;

import java.util.*;

public class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] f = new int[edges.length];
        int[] s = new int[edges.length];
        Arrays.fill(f, -1);
        Arrays.fill(s, -1);
        dfs(edges, node1, 0, f);
        dfs(edges, node2, 0, s);
        int asn = -1;
        int curMax = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            if (f[i] != -1 && s[i] != -1 && curMax > Math.max(f[i], s[i])) {
                curMax = Math.max(f[i], s[i]);
                asn = i;
            }
        }
        return asn;
    }

    private void dfs(int[] edges, int node1, int curLen, int[] f) {
        if (node1 == -1||f[node1]!=-1) {
            return;
        }
        f[node1] = curLen;
        dfs(edges, edges[node1], curLen + 1, f);
    }
}
