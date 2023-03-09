package 动态规划问题.爬楼梯;
public class Solution {
    public void test(){
        System.out.println(dp(6));
        System.out.println(fan(6));
    }
    public int climbStairs(int n) {
        int []temp=new int[n];
        temp[0]=1;
        temp[1]=2;
        int sum=0;
        for(int i=1;i<n-1;i++){
            temp[i+1]=temp[i-1]+temp[i];
        }
        return temp[n-1];
    }
    public  int fan(int n){
        if(n==1||n==2){
            return 1;
        }
        return fan(n-1)+fan(n-2);
    }
    public int dp(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
