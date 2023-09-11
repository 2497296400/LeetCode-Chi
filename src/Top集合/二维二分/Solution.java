package Top集合.二维二分;

public class Solution {
    public static void main(String[] args) {
        int[][] g = {{0}};
        Solution solution = new Solution();
        System.out.println(solution.getTarget(g, 3));
    }

    public boolean getTarget(int[][] g, int target) {
        int m = g.length;
        int n = g[0].length;
        int l = 0, r = m * n-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int cur = g[mid / n][mid % n];
            if (cur > target) {
                r = mid - 1;
            } else if (cur < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
