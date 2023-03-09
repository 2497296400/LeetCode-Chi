package 周赛.三百二十一场周赛.找出中枢整数;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotInteger(8));
    }
    public int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }
        int ans = -1;
        int presum = 0;
        for (int i = 1; i <= n; i++) {
            presum += i;
            int curSum = 0;
            for (int j = i; j <= n; j++) {
                curSum += j;
            }
            if (curSum == presum) {
                return i;
            }
        }
        return -1;
    }
}
