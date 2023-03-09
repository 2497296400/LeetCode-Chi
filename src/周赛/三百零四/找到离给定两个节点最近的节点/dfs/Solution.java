package 周赛.三百零四.找到离给定两个节点最近的节点.dfs;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int []nums={2,2,3,-1};
        Solution solution = new Solution();
        System.out.println(solution.closestMeetingNode(nums,0,1));
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int []first=new int[edges.length+1];
        Arrays.fill(first,-1);
        int []second=new int[edges.length+1];
        Arrays.fill(second,-1);
        dfs(edges,first,0,node1);
        dfs(edges,second,0,node2);
        int curMax=Integer.MAX_VALUE;
        int ans=-1;

        for(int i=0;i<edges.length;i++){
         if(first[i]==-1||second[i]==-1||curMax<=Math.max(first[i],second[i])){
             continue;
         }
         curMax=Math.max(first[i],second[i]);
         ans=i;

        }
        return ans;
    }

    private void dfs(int[] edges, int[] curGraph, int curLen, int node ) {
        if(node < 0 || curGraph[node]!=-1){
            return;
        }
        curGraph[node]=curLen;
        dfs(edges,curGraph,curLen+1,edges[node]);
    }
}
