package 基础数据结构.线段树.掉落的方块;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] post = {{9, 7}, {1, 9}, {3, 1}};
        System.out.println(solution.fallingSquares(post));
    }
    public HashMap<Integer,Integer>index(int [][]positions){
        TreeSet<Integer>pos=new TreeSet<>();
        for (int[] position : positions) {
            pos.add(position[0]);
            pos.add(position[0]+position[1]-1);
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        int count=0;
        for (Integer index : pos) {
            map.put(index, ++count);
        }
        return map;
    }
    public List<Integer> fallingSquares(int[][] positions) {
        HashMap<Integer, Integer> index = index(positions);
        int size = 0;
        size=index.size();
        SegmentTree segmentTree = new SegmentTree(size+1);
        List<Integer> list = new ArrayList<>();
        int left = 1;
        int root = 1;
        int right = size;
        int curMax = 0;
        for (int[] position : positions) {
            int L = index.get(position[0]);
            int R= index.get(position[0]+position[1]-1);
            int height=segmentTree.query(L, R, left, right, root)+position[1];
            curMax=Math.max(curMax, height);
            list.add(curMax);
            segmentTree.upDate(L, R, height, left, right, root);
        }
        return list;
    }
}

class SegmentTree {
    private int[] max;
    private int[] change;
    private boolean[] update;

    public SegmentTree(int size) {
        int capacity = size * 4;
        max = new int[capacity];
        change = new int[capacity];
        update = new boolean[capacity];
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
