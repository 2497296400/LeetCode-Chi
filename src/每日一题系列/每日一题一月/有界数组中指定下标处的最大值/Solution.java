package 每日一题系列.每日一题一月.有界数组中指定下标处的最大值;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxValue(4, 0, 4));
    }

    public int maxValue(int n, int index, int maxSum) {
        int l = 1;
        int r = maxSum;
        int ans = 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isVid(mid, index, maxSum, n)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private boolean isVid(int mid, int index, int maxSum, int n) {
        int l = index;
        int r = n - index - 1;
        long ls = getum(l, mid), rs = getum(r, mid);
        return mid + ls + rs <= maxSum;
    }

    private long getum(int cur, int mid) {
        if (cur + 1 < mid) {
            int small = mid - cur;
            return (long) (mid - 1 + small) * cur / 2;
        } else {
            int c = cur - mid+1;
            return ((long) mid * (mid - 1) / 2) + c;
        }
    }
}