package 每日一题七月.设计循环队列;

public class Solution {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        System.out.println( myCircularQueue.enQueue(4));

        myCircularQueue.deQueue();

        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());
    }
}

class MyCircularQueue {
    class Node {
        int value;
        Node next;
        Node pre;
        public Node(int value) {
            this.value = value;
        }
    }

    Node curHead;
    Node curTail;
    int curSize;
    int SIZE;

    public MyCircularQueue(int k) {
        this.SIZE = k;
        curSize = 0;
    }

    public boolean enQueue(int value) {
        boolean flag=false;
        if (curSize < SIZE) {
            flag=true;
            if (curSize ==0 ) {
                curHead = new Node(value);
                curTail =curHead;
                curHead.next = curTail;
                curTail.pre=curHead;
                curSize++;
            }else {
                Node  curNode = new Node(value);
               curNode.next=curHead;
               curNode.pre=curTail;
               curTail.next=curNode;
               curTail=curNode;
               curSize++;
            }
        }
        return flag;
    }

    public boolean deQueue() {
        if(curSize>0){
            curTail.next=curHead.next;
            curHead=curHead.next;
            curHead.pre=curTail;
            curSize--;
            return true;
        }
        return false;
    }

    public int Front() {
        if(curSize>0){
            int value = curHead.value;
            return value;
        }
        return -1;
    }

    public int Rear() {
        if(curSize>0){
            int value= curTail.value;
            return value;
        }
        return -1;
    }



    public boolean isEmpty() {
        return  curSize==0;
    }

    public boolean isFull() {
        return  curSize==SIZE;

    }
}
