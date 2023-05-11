package 每日一题系列.每日一题四月.重温线段树;

public class SegmentTree {
    int[] sum;
    boolean[] lazy;
    int[] arr;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        sum = new int[n * 4];
        lazy = new boolean[n * 4];
    }

    private void curDo(int root) {
        sum[root] = sum[root * 2] + sum[root * 2 + 1];
    }

    private void nextDo(int root, int l, int r, int val) {
        sum[root]+= (r - l + 1) * val;
        lazy[root] = !lazy[root];
    }

    public void build(int root, int l, int r) {
        if (l == r) {
            sum[root] = arr[l - 1];
            return;
        }
        int mid = (l + r) / 2;
        build(root * 2, l, mid);
        build(root * 2 + 1, mid + 1, r);
        curDo(root);
    }

    public void updata(int root, int l, int r, int L, int R, int val) {
        if (l >= L && r <= R) {
            nextDo(root, l, r, val);
            return;
        }
        int mid = (l + r) / 2;
        if (lazy[root]) {
            nextDo(root * 2, l, mid, val);
            nextDo(root * 2 + 1, mid + 1, r, val);
            lazy[root] = false;
        }
        if (mid >= L) {
            updata(root * 2, l, mid, L, R, val);
        }
        if (mid < R) {
            updata(root * 2 + 1, mid + 1, r, L, R, val);
        }
        curDo(root);
    }

    public int query(int root, int l, int r, int L, int R) {
        if (l >= L && r <= R) {
            return sum[root];
        }
        int ans = 0;
        int mid = (l + r) / 2;
        if (mid >= L) {
            ans += query(root * 2, l, mid, L, R);
        }
        if (mid < R) {
            ans += query(root * 2 + 1, mid + 1, r, L, R);
        }
        curDo(root);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.build(1, 1, arr.length);
        System.out.println(segmentTree.query(1, 1, arr.length, 2, 4));
        segmentTree.updata(1, 1, arr.length, 2, 4, 10);
        System.out.println(segmentTree.query(1, 1, arr.length, 2, 4));
        segmentTree.updata(1, 1, arr.length, 2, 4, 10);
        System.out.println(segmentTree.query(1, 1, arr.length, 2, 4));
        System.out.println(segmentTree.query(1, 1, arr.length, 2, 5));
    }
}
