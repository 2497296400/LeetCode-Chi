package 基础数据结构.LRU;

import java.util.HashMap;

public class LRU {
    HashMap<Integer, Integer> dataMap;
    HashMap<Integer, Node> nodeMap;
    int size;
    Node head;
    Node tail;

    public LRU(int N) {
        dataMap = new HashMap<>();
        nodeMap = new HashMap<>();
        size = N;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        dataMap.put(key, value);
        Node curNode = nodeMap.get(key);
        if (curNode == null) {
            curNode = new Node(key);
            nodeMap.put(key, curNode);
        }
        moveHead(curNode);
        if (dataMap.size() > size) {
            Integer removeKey = removeTail();
            nodeMap.remove(removeKey);
            dataMap.remove(removeKey);
        }
    }

    private void moveHead(Node node) {
        if (node.pre == null) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
            return;
        }
        removeNode(node);
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private Integer removeTail() {
        int var = tail.pre.var;
        removeNode(tail.pre);
        return var;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public int get(int key) {
        Integer ans = dataMap.getOrDefault(key, -1);
        if (ans != -1) {
            moveHead(nodeMap.get(key));
        }
        return ans;
    }

    class Node {
        int var;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(int var) {
            this.var = var;
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put(1, 2);
        lru.put(2, 4);
        lru.put(5, 6);
        lru.put(9, 9);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
        lru.put(1, 1);
        System.out.println(lru.get(5));
    }
}
