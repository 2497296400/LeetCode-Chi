package 基础数据结构.线段树.更新数组后处理求和查询;

import java.util.Arrays;

public class Solution {
    int[] cnt;
    boolean[] lazy;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n1 = {1, 0, 1};
        int[] n2 = {0, 0, 0};
        int[][] q = {{1, 1, 1}, {2, 1, 0}, {3, 0, 0}};
        System.out.println(Arrays.toString(solution.handleQuery(n1, n2, q)));
    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        cnt = new int[nums1.length * 4];
        lazy = new boolean[nums1.length * 4];
        long sum = 0L;
        for (int i : nums2) {
            sum += i;
        }
        int n = 0;
        for (int[] query : queries) {
            if (query[0] == 3) {
                n++;
            }
        }
        long[] ans = new long[n];
        n = 0;
        bulid(1, 1, nums1.length, nums1);
        for (int[] query : queries) {
            int chioce = query[0];
            int l = query[1];
            int r = query[2];
            if (chioce == 1) {
                updata(1, 1, nums1.length, l + 1, r + 1);
            }
            if (chioce == 2) {
                sum += (long) cnt[1] * l;
            }
            if (chioce == 3) {
                ans[n++] = sum;
            }
        }
        return ans;
    }

    private void mainTain(int root) {
        cnt[root] = cnt[root * 2] + cnt[root * 2 + 1];
    }

    private void nextDo(int root, int l, int r) {
        cnt[root] = r - l + 1 - cnt[root];
        lazy[root] = !lazy[root];
    }

    private void bulid(int root, int l, int r, int[] nums) {
        if (l == r) {
            cnt[root] = nums[l - 1];
            return;
        }
        int mid = (l + r) / 2;
        bulid(root * 2, l, mid, nums);
        bulid(root * 2 + 1, mid + 1, r, nums);
        mainTain(root);
    }

    private void updata(int root, int l, int r, int L, int R) {
        if (L <= l && R >= r) {
            nextDo(root, l, r);
            return;
        }
        int mid = (l + r) / 2;
        if (lazy[root]) {
            nextDo(root * 2, l, mid);
            nextDo(root * 2 + 1, mid + 1, r);
            lazy[root] = false;
        }
        if (mid >= L) {
            updata(root * 2, l, mid, L, R);
        }
        if (mid < R) {
            updata(root * 2 + 1, mid + 1, r, L, R);
        }
        mainTain(root);
    }

    private int query(int root, int l, int r, int L, int R) {
        if (l >= L && r <= R) {
            return cnt[root];
        }
        int sum = 0;
        int mid = (l + r) / 2;
        if (lazy[root]) {
            nextDo(root * 2, l, mid);
            nextDo(root * 2 + 1, mid + 1, r);
            lazy[root] = false;
        }

        if (mid >= L) {
            sum += query(root * 2, l, mid, L, R);
        }
        if (mid < r) {
            sum += query(root * 2 + 1, mid + 1, r, L, R);
        }
        mainTain(root);
        return sum;
    }
}
