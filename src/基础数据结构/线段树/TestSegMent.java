package 基础数据结构.线段树;

import java.util.Queue;
import java.util.zip.ZipEntry;

public class TestSegMent {
    int[] arr;
    int[] lazy;
    int[] sum;
    int[] change;
    boolean[] update;

    public TestSegMent(int[] origin) {
        arr = new int[origin.length + 1];
        int capacity = arr.length * 4;
        lazy = new int[capacity];
        change = new int[capacity];
        update = new boolean[capacity];
        sum = new int[capacity];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = origin[i - 1];
        }
    }

    private void pushUp(int root) {
        sum[root] = sum[root << 1] + sum[root << 1 | 1];
    }

    public void build(int left, int right, int root) {
        if (left == right) {
            sum[root] = arr[left];
            return;
        }
        int mid = (left + right) >> 1;
        build(left, mid, root << 1);
        build(mid + 1, right, root << 1 | 1);
        pushUp(root);
    }

    public void add(int L, int R, int T, int left, int right, int root) {
        if (left >= L && right <= R) {
            sum[root] += T * (right - left + 1);
            lazy[root] += T;
            return;
        }
        int mid = (left + right) >> 1;
        int leftSum = mid - left + 1;
        int rightSum = right - mid;
        puDown(leftSum, rightSum, root);
        if (L <= mid) {
            add(L, R, T, left, mid, root << 1);
        }
        if (R > mid) {
            add(L, R, T, mid + 1, right, root << 1 | 1);
        }
        pushUp(root);
    }

    public void upDate(int L, int R, int T, int left, int right, int root) {
        if (left >= L && right <= R) {
            change[root] = T;
            sum[root] = (right - left + 1) * T;
            lazy[root] = 0;
            update[root] = true;
            return;
        }
        int mid = (left + right) >> 1;
        int leftSum = mid - left + 1;
        int rightSum = right - mid;
        puDown(leftSum, rightSum, root);
        if (L <= mid) {
            upDate(L, R, T, left, mid, root << 1);
        }
        if (R > mid) {
            upDate(L, R, T, mid + 1, right, root << 1 | 1);
        }
        pushUp(root);
    }

    public int query(int L, int R, int left, int right, int root) {
        if (left >= L && right <= R) {
            return sum[root];
        }
        int mid = (left + right) >> 1;
        int leftSum = mid - left + 1;
        int rightSUm = right - mid;
        int ans = 0;
        puDown(leftSum, rightSUm, root);
        if (L <= mid) {
            ans += query(L, R, left, mid, root << 1);
        }
        if (R > mid) {
            ans += query(L, R, mid + 1, right, root<<1|1);
        }
        return ans;
    }

    private void puDown(int leftSum, int rightSum, int root) {
        if (update[root]) {
            update[root] = false;

            update[root << 1] = true;
            update[root << 1 | 1] = true;

            sum[root << 1] = change[root] * leftSum;
            sum[root << 1 | 1] = change[root] * rightSum;

            change[root << 1] = change[root];
            change[root << 1 | 1] = change[root];

            lazy[root << 1] = 0;
            lazy[root << 1 | 1] = 0;
        }

        if (lazy[root] != 0) {
            sum[root << 1] += leftSum * lazy[root];
            sum[root << 1 | 1] += rightSum * lazy[root];

            lazy[root << 1] += leftSum * lazy[root];
            lazy[root << 1 | 1] += rightSum * lazy[root];

            lazy[root] = 0;
        }
    }
}
