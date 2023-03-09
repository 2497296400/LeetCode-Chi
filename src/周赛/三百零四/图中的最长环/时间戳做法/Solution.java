package 周赛.三百零四.图中的最长环.时间戳做法;

public class Solution {
    public static void main(String[] args) {
        int []nums={3,3,4,2,3};
        Solution solution = new Solution();
        System.out.println(solution.longestCycle(nums));
    }
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int ans=-1;
        int []time=new int[n];
        for(int i=0,clock=1;i<n;i++){
            if(time[i]>0){
                continue;
            }
            for(int x=i,startTime=clock;x>=0;x=edges[x]){
                if(time[x]>0){
                    if(time[x]>=startTime){
                        ans=Math.max(ans,clock-time[x]);
                    }
                    break;
                }
                time[x]=clock++;
            }
        }
        return ans;
    }
}
