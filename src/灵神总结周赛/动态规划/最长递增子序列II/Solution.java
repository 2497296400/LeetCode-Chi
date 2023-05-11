package 灵神总结周赛.动态规划.最长递增子序列II;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int []nums={4,2,1,4,3,4,5,8,15};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(nums, 3));
    }
    public int lengthOfLIS(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        segTree segTree = new segTree(max);
        int ans = 0;
        for (int num : nums) {
            if (num == 1) {
                segTree.updata(1, 1, max, 1, 1, 1);
            } else {
                int res = 1 + segTree.query(1, 1, max, Math.max(num - k, 1), num - 1);
                segTree.updata(1, 1, max, num, num, res);
                ans = Math.max(res, ans);
            }
        }
        return ans;
    }
}

class segTree {
    int[] max;
    boolean[] lazy;

    public segTree(int N) {
        lazy = new boolean[4 * N];
        max = new int[4 * N];
    }

    private void doMain(int root) {
        max[root] = Math.max(max[root << 1], max[root << 1 | 1]);
    }

    private void nextDo(int root, int val) {
        max[root] = val;
        lazy[root] = !lazy[root];
    }

    public void updata(int root, int l, int r, int L, int R, int val) {
        if (l >= L && r <= R) {
            nextDo(root, val);
            return;
        }
        int mid = (l + r) / 2;
        if (lazy[root]) {
            nextDo(root << 1, val);
            nextDo(root << 1 | 1, val);
            lazy[root] = false;
        }
        if (mid >= L) {
            updata(root << 1, l, mid, L, R, val);
        }
        if (mid < R) {
            updata(root << 1 | 1, mid + 1, r, L, R, val);
        }
        doMain(root);
    }

    public int query(int root, int l, int r, int L, int R) {
        if (l >= L && r <= R) {
            return max[root];
        }
        int mid = (l + r) / 2;
        int leftMax = 0, rightMax = 0;
        if (mid >= L) {
            leftMax = query(root << 1, l, mid, L, R);
        }
        if (mid < R) {
            rightMax = query(root << 1 | 1, mid + 1, r, L, R);
        }
        return Math.max(leftMax, rightMax);
    }
}
