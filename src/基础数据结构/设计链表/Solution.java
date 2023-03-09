package 基础数据结构.设计链表;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        MyLinkedList linkedList = new MyLinkedList();
        Random random = new Random();
        linkedList.addAtHead(0);
        list.add(0);

        for (int i = 0; i < 100; i++) {
            int cur = random.nextInt(1000);
            int curSize = random.nextInt(linkedList.size);
            linkedList.addAtIndex(curSize, cur);
            list.add(curSize, cur);
        }
        for (int i = 0; i < 10; i++) {
            int curSize = random.nextInt(linkedList.size);
            linkedList.deleteAtIndex(curSize);
            list.remove(curSize);
        }
        Node cur = linkedList.head.next;
        for (int i = 0; i < list.size(); i++) {
            if (cur.val != list.get(i)) {
                System.out.println("fal"+" ----" + i);
            }
            cur = cur.next;
        }
        for(int i = 0 ;i<20;i++){
            int curSize = random.nextInt(linkedList.size);
            System.out.println(linkedList.get(curSize));
            System.out.println(list.get(curSize));
            System.out.println("------------");
        }
//        System.out.println(list);
//        linkedList.print();
    }
}

class MyLinkedList {
    public int size;
    public Node head;
    private Node tail;

    public MyLinkedList() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {
        Node cur;
        if (index >= size || index < 0) {
            return -1;
        }
        if (index < size - index) {
            cur = head.next;
            while (index-- > 0) {
                cur = cur.next;
            }
        } else {
            index = size - index - 1;
            cur = tail.pre;
            while (index-- > 0) {
                cur = cur.pre;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        Node next;
        Node pre;
        if (index > size) {
            return;
        }
        index = Math.max(0, index);
        if (index < size - index) {
            next = head.next;
            while (index-- > 0) {
                next = next.next;
            }
            pre = next.pre;
        } else {
            index = size - index;
            pre = tail.pre;
            while (index-- > 0) {
                pre = pre.pre;
            }
            next = pre.next;
        }
        Node newNode = new Node(val, next, pre);
        pre.next = newNode;
        next.pre = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node next;
        Node pre;
        if (index < size - index) {
            next = head.next;
            while (index-- > 0) {
                next = next.next;
            }
            pre = next.pre;
            next = next.next;
        } else {
            index = size - index-1;
            pre = tail.pre;
            while (index-- > 0) {
                pre = pre.pre;
            }
            next = pre.next;
            pre = pre.pre;
        }
        pre.next = next;
        next.pre = pre;
        size--;
    }

    public void print() {
        Node cur = head.next;
        while (cur.next != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}

class Node {
    int val;
    Node next;
    Node pre;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next, Node pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }
}