package 异或和类型.最大异或和子数组;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {14,70,53,83,49,91,36,80,92,51,66,70};
        NumTire ans = new NumTire();
        int max=  0;
        int xor=0;
        ans.add(0);
        for(int i =0;i<arr.length;i++){
            xor^=arr[i];
            max=Math.max(max, ans.maxXor(xor));
            ans.add(xor);
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
            //看符号
            int best = move == 31 ? path : (path ^ 1);
            //当前的选择
            best = cur.next[best] != null ? best : (best ^ 1);
            //当前的异或结果

            res |= (path ^ best) << move;
            cur = cur.next[best];
        }
        return res;
    }
}
