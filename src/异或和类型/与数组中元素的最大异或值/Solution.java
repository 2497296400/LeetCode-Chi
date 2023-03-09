package 异或和类型.与数组中元素的最大异或值;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr={0,1,2,3,4};
        int [][]q={{3,1},{1,3},{5,6}};
        System.out.println(Arrays.toString(solution.maximizeXor(arr, q)));
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        NumTire tire = new NumTire();
        for (int num : nums) {
            tire.add(num);
        }
        int[] arr = new int[queries.length];
        int len = 0;
        for (int[] query : queries) {
            arr[len++] = tire.getmax(query[0], query[1]);
        }
        return arr;
    }
}

class Node {
    int min;
    Node[] nexts;

    public Node() {
        min = Integer.MAX_VALUE;
        nexts = new Node[20];
    }
}

class NumTire {
    Node head;

    public NumTire() {
        head = new Node();
    }

    public void add(int num) {
        Node cur = head;
        cur.min = Math.min(head.min, num);
        for (int move = 30; move >= 0; move--) {
            int path = (num >> move) & 1;
            cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
            cur = cur.nexts[path];
            cur.min = Math.min(cur.min, num);
        }
    }

    public int getmax(int num, int curMin) {
        if (head.min >curMin) {
            return -1;
        }
        Node cur = head;
        int ans = 0;
        for (int move = 30; move >= 0; move--) {
            int path = (num >> move) & 1;
            int best = path ^ 1;
            best ^= (cur.nexts[best] == null || cur.nexts[best].min > curMin) ? 1 : 0;
            ans |= (best ^ path) << move;
            cur = cur.nexts[best];
        }
        return ans;
    }
}
