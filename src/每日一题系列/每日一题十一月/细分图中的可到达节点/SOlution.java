package 每日一题系列.每日一题十一月.细分图中的可到达节点;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] eg = {{0, 1, 10}, {0, 2, 1}, {1, 2, 2}};
        System.out.println(solution.reachableNodes(eg, 6, 3));
    }

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]> path[] = new List[n];
        for (int i = 0; i < n; i++) {
            path[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            path[edge[0]].add(new int[]{edge[1], edge[2]});
            path[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        PriorityQueue<int[]> priorityQueuq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        priorityQueuq.add(new int[]{0, 0});
        while (!priorityQueuq.isEmpty()) {
            int[] cur = priorityQueuq.poll();
            for (int i = 0; i < path[cur[0]].size(); i++) {
                int[] next = path[cur[0]].get(i);
                int d = next[1] + cur[1] + 1;
                if(d<dis[next[0]]){
                    dis[next[0]] = d;
                    priorityQueuq.add(new int[]{next[0],d});
                }
            }
        }
        int ans=0;
        //先把原图中距离符合要求的点拿进来：
        for(int i=0;i<n;i++){if(dis[i]<=maxMoves){ans++;}}
        //再遍历每个边，把插入的可能符合要求的点算进来
        for(int i=0;i<edges.length;i++){
            int e[]=edges[i];
            ans+=Math.min(e[2],Math.max(0,maxMoves-dis[e[0]])+Math.max(0,maxMoves-dis[e[1]]));
        }
        return ans;
    }
}
