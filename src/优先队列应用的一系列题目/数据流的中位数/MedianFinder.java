package 优先队列应用的一系列题目.数据流的中位数;

import java.util.PriorityQueue;
/*

* */
public class MedianFinder {
    PriorityQueue<Integer> right, left;
    //想象成二叉搜索树 左边取个最大的 右边取个最小的
    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        left.add(num);
        right.offer(left.poll());
        if (left.size() < right.size()) {
            left.add(right.poll());
        }
    }

    public double findMedian() {
        return left.size() > right.size() ? left.peek() : (right.peek() + left.peek()) / 2.0;
    }
}

