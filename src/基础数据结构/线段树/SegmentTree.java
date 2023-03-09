package 基础数据结构.线段树;

public class SegmentTree {
    private int MAXN;
    private int[] arr;
    private int[] sum;
    private int[] lazy;
    private int[] change;
    private boolean[] update;

    public SegmentTree(int[] origin) {
        arr = new int[origin.length + 1];
        MAXN = arr.length;
        //取四倍
        int capacity = MAXN * 4;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = origin[i - 1];
        }
        sum = new int[capacity];
        lazy = new int[capacity];
        change = new int[capacity];
        update = new boolean[capacity];
    }

    //自己的累加和
    private void pushUp(int root) {
        int leftIndex = root * 2;
        int rightIndex = root * 2 + 1;
        sum[root] = sum[leftIndex] + sum[rightIndex];
    }

    public void build(int left, int right, int root) {
        if (left == right) {
            sum[root] = arr[left];
            return;
        }
        int mid = (left + right) / 2;
        int leftIndex = root * 2;
        int rightIndex = root * 2 + 1;
        build(left, mid, leftIndex);
        build(mid + 1, right, rightIndex);
        pushUp(root);
    }

    public void add(int targetLeft, int targetRight, int task,
                    int left, int right, int root) {
        //如果全包
        if (left>=targetLeft && right <= targetRight) {
            sum[root] += task * (right - left + 1);
            lazy[root] += task;
            return;
        }
        //任务没有全包
        int mid = (left + right) / 2;
        int leftSum = mid - left + 1;
        int rightSum = right - mid;
        pushDown(root, leftSum, rightSum);
        if (targetLeft <= mid) {
            add(targetLeft, targetRight, task, left, mid, root * 2);
        }
        if (targetRight > mid) {
            add(targetLeft, targetRight, task, mid + 1, right, root * 2 + 1);
        }
        pushUp(root);
    }

    public void upData(int targetLeft, int targetRight, int task,
                       int left, int right, int root) {
        //如果全包
        if (left>=targetLeft&& right <= targetRight) {
            update[root] = true;
            change[root] = task;
            sum[root] = task * (right - left + 1);
            lazy[root] = 0;
            return;
        }
        //任务没有全包
        int mid = (left + right) / 2;
        int leftSum = mid - left + 1;
        int rightSum = right - mid;
        pushDown(root, leftSum, rightSum);
        if (targetLeft <= mid) {
            upData(targetLeft, targetRight, task, left, mid, root * 2);
        }
        if (targetRight > mid) {
            upData(targetLeft, targetRight, task, mid + 1, right, root * 2 + 1);
        }
        pushUp(root);
    }

    public long query(int targetLeft, int targetRight, int left, int right, int root) {
        if (left>=targetLeft   && right <= targetRight) {
            return sum[root];
        }

        int mid = (left + right) / 2;
        int leftSum = mid-left + 1;
        int rightSum= right-mid;
        pushDown(root, leftSum, rightSum);
        long ans = 0;
        int leftIndex = root * 2;
        int rightIndex = root * 2 + 1;
        if (targetLeft <= mid) {
            ans += query(targetLeft, targetRight, left, mid, leftIndex);
        }
        if (targetRight > mid) {
            ans += query(targetLeft, targetRight, mid + 1, right, rightIndex);
        }
        return ans;
    }
    private void pushDown(int root, int leftSum, int rightSum) {
        int leftIndex = root * 2;
        int rightIndex = root * 2 + 1;
        if (update[root]) {

            update[leftIndex] = true;
            update[rightIndex] = true;

            change[leftIndex] = change[root];
            change[rightIndex] = change[root];
            lazy[leftIndex] = 0;
            lazy[rightIndex] = 0;

            sum[leftIndex] = change[root] * leftSum;
            sum[rightIndex] = change[root] * rightSum;

            update[root] = false;
        }
        if (lazy[root] != 0) {
            lazy[leftIndex] += lazy[root];
            lazy[rightIndex] += lazy[root];
            sum[leftIndex] += lazy[root] * leftSum;
            sum[rightIndex] += lazy[root] * rightSum;
            lazy[root] = 0;
        }
    }
}
