package 灵神总结周赛.数据结构.预算内的最多机器人数目;

public class Solution {
    segTree segTree;
    int n;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = {19, 63, 21, 8, 5, 46, 56, 45, 54, 30, 92, 63, 31, 71, 87, 94, 67, 8, 19, 89, 79, 25};
        int[] sr = {91, 92, 39, 89, 62, 81, 33, 99, 28, 99, 86, 19, 5, 6, 19, 94, 65, 86, 17, 10, 8, 42};
        System.out.println(solution.maximumRobots(ar, sr, 85));
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        long[] pre = new long[runningCosts.length + 1];
        for (int i = 1; i <= runningCosts.length; i++) {
            pre[i] = pre[i - 1] + runningCosts[i - 1];
        }
        n = chargeTimes.length;
        segTree = new segTree(chargeTimes);
        segTree.build(1, 1, n);
        int l = 0, r = 0;
        int ans = 0;
        while (r < chargeTimes.length) {
            long curSum = query(l + 1, r + 1) + (r - l + 1) * preSum(pre, l, r);
            if (curSum <= budget) {
                ans = Math.max(ans, r - l + 1);
            }
            while (curSum > budget) {
                l++;
                curSum = query(l + 1, r + 1) + (r - l + 1) * preSum(pre, l, r);
            }
            r++;
        }
        return ans;
    }

    public int query(int l, int r) {
        return segTree.query(1, 1, n, l, r);
    }

    public long preSum(long[] pre, int l, int r) {
        return pre[r + 1] - pre[l];
    }
}

class segTree {
    int[] max;
    boolean[] lazy;
    int[] arr;

    public segTree(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        max = new int[n * 4];
        lazy = new boolean[n * 4];
    }

    private void curDo(int root) {
        max[root] = Math.max(max[root << 1], max[root << 1 | 1]);
    }

    public void build(int root, int l, int r) {
        if (l == r) {
            max[root] = arr[l - 1];
            return;
        }
        int mid = (l + r) / 2;
        build(root << 1, l, mid);
        build(root << 1 | 1, mid + 1, r);
        curDo(root);
    }

    public int query(int root, int l, int r, int L, int R) {
        if (l >= L && r <= R) {
            return max[root];
        }
        int mid = (l + r) / 2;
        int lMax = 0, rMax = 0;
        if (L <= mid) {
            lMax = query(root << 1, l, mid, L, R);
        }
        if (R > mid) {
            rMax = query(root << 1 | 1, mid + 1, r, L, R);
        }
        return Math.max(lMax, rMax);
    }
}
