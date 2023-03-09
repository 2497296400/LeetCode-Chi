package 异或和类型.两数最大异或;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {14,70,53,83,49,91,36,80,92,51,66,70};
      NumTire ans = new NumTire();
        for (int i : arr) {
            ans.add(i);
        }
        int max= 0;
        for (int i : arr) {
            max =Math.max(max,  ans.maxXor(i));
        }
        System.out.println(max);
    }
}

class Node {
   Node[] next;

    public Node() {
        next = new Node[2];

    }
}

class NumTire {
    Node head;


    public NumTire() {
        head = new Node();
    }

    public void add(int num) {
        Node cur = head;
        for (int move = 31; move >= 0; move--) {
            int path = (num >> move) & 1;
            cur.next[path] = cur.next[path] == null ? new Node() : cur.next[path];
            cur = cur.next[path];
        }
    }

    public int maxXor(int num) {
        Node cur = head;
        int res = 0;
        for (int move = 31; move >= 0; move--) {
            int path = (num >> move) & 1;
            int best = move == 31 ? path : (path ^ 1);
            best = cur.next[best] != null ? best : (best ^ 1);
            res |= (path ^ best) << move;
            cur = cur.next[best];
        }
        return res;
    }
}
