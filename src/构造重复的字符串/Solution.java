package 构造重复的字符串;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] num = new int[26];
        int res = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 97]++;
        }
        Queue<Node> queue = new LinkedList<>();
        for (int i = 25; i >= 0; i--) {
            if (num[i] != 0) {
                queue.add(new Node((char) (i + 97), num[i]));
            }
        }
        while (!queue.isEmpty()) {
            if (queue.peek().count > repeatLimit) {
                for (int i = 0; i < repeatLimit; i++, queue.peek().count--) {
                    sb.append(queue.peek().c);
                }
                Queue<Node> temp = new LinkedList<>();
                temp.add(queue.poll());
                if (queue.peek() != null) {
                    sb.append(queue.peek().c);
                    queue.peek().count--;
                    if (queue.peek().count == 0) {
                        queue.poll();
                    }
                    temp.addAll(queue);
                    queue = temp;

                }
            } else {
                for (int i = 0; i < queue.peek().count; i++) {
                    sb.append(queue.peek().c);
                }
                queue.poll();
            }
        }
        return sb.toString();
    }

}

class Node {
    char c;
    int count;

    public Node(char c, int count) {
        this.c = c;
        this.count = count;
    }

    public Node() {

    }
}
