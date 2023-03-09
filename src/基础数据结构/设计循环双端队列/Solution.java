package 每日一题八月.设计循环双端队列;
//数组
class MyCircularDeque {
    int SIZE = 0;
    private final int[] elements;
    int head = 0;
    int tail;

    public MyCircularDeque(int k) {
        elements = new int[k];
        tail = k - 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        elements[head = head == 0 ? elements.length - 1 : head - 1] = value;
        SIZE++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        elements[tail = tail == elements.length - 1 ? 0 : tail + 1] = value;
        return true;

    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = head == elements.length - 1 ? 0 : head + 1;
        SIZE--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = tail == 0 ? elements.length - 1 : tail - 1;
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return elements[head];

    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return elements[tail];
    }

    public boolean isEmpty() {
        return SIZE==0;

    }

    public boolean isFull() {
        return SIZE==elements.length;

    }
}