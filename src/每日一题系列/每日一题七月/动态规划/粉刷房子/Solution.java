package 每日一题系列.每日一题七月.动态规划.粉刷房子;

public class Solution {
    public static void main(String[] args) {
        int [][]cost={{17,2,17},{16,16,5},{14,3,19
        },{5,6,9},{1,3,5}};
        System.out.println(process(cost,0,0));
        System.out.println(minCost(cost));
    }
    public static int minCost(int[][] costs) {
        int n = costs.length;
        for(int i=1;i<costs.length;i++){
            costs[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1]+=Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2]+=Math.min(costs[i-1][1],costs[i-1][0]);
        }
        return Math.min(costs[n-1][0],Math.min(costs[n-1][1],costs[n-1][2]));
    }
    public static int process(int [][]cost,int temp,int index){
        if(temp==cost.length){
            return 0;
        }
        if(index==0){
            return Math.min(process(cost,temp+1,1)+cost[temp][1],process(cost,temp+1,2)+cost[temp][2]);
        }
        if(index==1){
            return Math.min(process(cost,temp+1,0)+cost[temp][0],process(cost,temp+1,2)+cost[temp][2]);
        }
        if(index==2){
            return Math.min(process(cost,temp+1,1)+cost[temp][1],process(cost,temp+1,0)+cost[temp][0]);
        }
        return 0;
    }
}

