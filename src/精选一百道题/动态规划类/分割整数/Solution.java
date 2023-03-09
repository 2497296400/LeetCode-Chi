package 精选一百道题.动态规划类.分割整数;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.splitDate(4));
    }

    public int splitDate(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return process(1, n);
    }

    private int process(int pre, int next) {
        if (next == 0) {
            return 1;
        }
        if (pre > next) {
            return 0;
        }
        int way = 0;
        for (int cur = pre; cur <= next; cur++) {
            way += process(cur, next - cur);
        }
        return way;
    }
}
