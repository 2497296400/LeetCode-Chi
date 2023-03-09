package 周赛.第三百一十四.处理用时最长的那个任务的员工;

public class Solutiion {
    public static void main(String[] args) {
        Solutiion solutiion = new Solutiion();

    }
    public int hardestWorker(int n, int[][] logs) {
        int ans = 0;
        int max = 0;
        ans = logs[0][0];
        max = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int curSum = logs[i][1] - logs[i - 1][1];
            if (curSum > max) {
                ans =logs[i][0];
                max = curSum;
            }else if(curSum==max){
                ans=Math.min(ans, logs[i][0]);

            }
        }
        return ans;
    }
}
