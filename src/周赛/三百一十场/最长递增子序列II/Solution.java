package 周赛.三百一十场.最长递增子序列II;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,1,0,3,2,3};
        int k = 10;
        System.out.println(solution.lengthOfLIS(arr, k));
    }

    public int lengthOfLIS(int[] nums, int k) {
        int max = 0;
        for(int i=  0;i<nums.length;i++){
          nums[i]+=(int)1e5;
        }
        for (int num : nums) {
            max = Math.max(max, num);
        }
        SegmentTree segmentTree = new SegmentTree(max);
        int ans = 1;
        for (int num : nums) {
            if (num == 1) {
                segmentTree.upDate(1, 1, 1, 1, max, 1);
            } else {
                int res = 1 + segmentTree.query( 1, num-1 , 1, max, 1);
                segmentTree.upDate(num, num , res, 1, max, 1);
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }
}

class SegmentTree {
    int[] max;
    boolean[] update;
    int[] change;

    public SegmentTree(int size) {
        int capacity = size << 2;
        max = new int[capacity];
        update = new boolean[capacity];
        change = new int[capacity];
    }

    private void pushUp(int root) {
        max[root] = Math.max(max[root << 1], max[root << 1 | 1]);
    }

    public void upDate(int L, int R, int T, int left, int right, int root) {
        if (left >= L && right <= R) {
            max[root] = T;
            change[root] = T;
            update[root] = true;
            return;
        }
        int mid = (left + right) >> 1;
        puDown(root);
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
            return max[root];
        }
        int mid = (left + right) >> 1;
        puDown(root);
        int leftMax = 0;
        int rightMax = 0;
        if (L <= mid) {
            leftMax = query(L, R, left, mid, root << 1);
        }
        if (R > mid) {
            rightMax = query(L, R, mid + 1, right, root << 1 | 1);
        }
        pushUp(root);
        return Math.max(leftMax, rightMax);
    }

    private void puDown(int root) {
        if (update[root]) {
            update[root] = false;

            update[root << 1] = true;
            update[root << 1 | 1] = true;

            max[root << 1] = change[root];
            max[root << 1 | 1] = change[root];

            change[root << 1] = change[root];
            change[root << 1 | 1] = change[root];


        }
    }
}

