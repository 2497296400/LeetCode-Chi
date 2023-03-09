package 每日一题八月.设计循环双端队列;

public class Test {
    public static void main(String[] args) {
        MyCircularDeque1 deque1 = new MyCircularDeque1(5);
        deque1.insertFront(1);

        deque1.insertFront(2);
        deque1.insertFront(3);
        deque1.insertLast(4);
        deque1.insertLast(5);

    }
}

class MyCircularDeque1 {
    private class Node {
        int var;
        Node pre;
        Node next;

        public Node(int var) {
            this.var = var;
        }
    }

    private Node head, tail;
    private int capacity;
    private int size;

    public MyCircularDeque1(int k) {
        capacity = k;
        size = 0;

    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;

        }
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = head.next;
        if (head != null) {
            head.pre = null;
        }
        size--;
        return true;

    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = tail.pre;
        if (tail != null) {
            tail.next = null;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.var;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.var;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;

    }
}
