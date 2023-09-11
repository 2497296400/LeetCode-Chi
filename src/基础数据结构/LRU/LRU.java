package 基础数据结构.LRU;

import java.util.HashMap;

public class LRU {
    Node head;
    Node tail;
    int size;
    HashMap<Integer, Node> dataMap;
    HashMap<Node, Integer> nodeMap;

    public LRU(int size) {
        dataMap = new HashMap<>();
        nodeMap = new HashMap<>();
        this.size = size;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        Node curNode = dataMap.get(key);
        if (curNode == null) {
            curNode = new Node(value);
            dataMap.put(key, curNode);
            nodeMap.put(curNode, key);
        } else {
            curNode.var = value;
        }
        if (dataMap.size() > size) {
            removeTail();
        }
        moveHead(curNode);
    }

    private void moveHead(Node curNode) {
        if (curNode.pre != null) {
            removeNode(curNode);
        }
        curNode.next = head.next;
        head.next.pre = curNode;
        curNode.pre = head;
        head.next = curNode;
    }

    private void removeNode(Node curNode) {
        curNode.pre.next = curNode.next;
        curNode.next.pre = curNode.pre;
    }


    private void removeTail() {
        Node pre = tail.pre;
        removeNode(pre);
        Integer remove = nodeMap.remove(pre);
        dataMap.remove(remove);
    }

    public int get(int key) {
        Node var = dataMap.getOrDefault(key, null);
        if (var == null) {
            return -1;
        }
        moveHead(var);
        return var.var;
    }

    class Node {
        int var;
        Node next;
        Node pre;

        public Node(int var) {
            this.var = var;
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1, 2);
        lru.put(1, 3);
        lru.put(2, 5);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
        System.out.println(lru.get(5));
    }
}
