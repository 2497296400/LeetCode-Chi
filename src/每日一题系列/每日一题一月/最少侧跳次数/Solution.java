package 每日一题系列.每日一题一月.最少侧跳次数;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 2, 1, 0, 3, 0};
        System.out.println(solution.minSideJumps(arr));
    }

    public int minSideJumps(int[] obstacles) {
        int status = 2;
        int curLen = 0;
        Integer [][]dp =new Integer[3+1][obstacles.length];
        return fun(obstacles, curLen, status,dp);
    }

    private int fun(int[] obstacles, int curLen, int status, Integer[][] dp) {
        if (curLen == obstacles.length - 1) {
            return status == obstacles[curLen] ? 1 : 0;
        }

        if(dp[status][curLen]!=null){
            return dp[status][curLen];
        }
        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;
        if (obstacles[curLen + 1] == status) {
            for (int i = 1; i <= 3; i++) {
                if (i != obstacles[curLen + 1] && i != obstacles[curLen]) {
                    p1 = Math.min(p1, fun(obstacles, curLen + 1, i, dp) + 1);
                }
            }
        } else {
            p2 = fun(obstacles, curLen + 1, status, dp);
        }
        dp[status][curLen]=Math.min(p1, p2);
        return Math.min(p1, p2);
    }
}