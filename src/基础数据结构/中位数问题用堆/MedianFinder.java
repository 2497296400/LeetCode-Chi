package 基础数据结构.中位数问题用堆;

import java.util.PriorityQueue;

public class MedianFinder {
    /**
     * initialize your data structure here.
     */
    public PriorityQueue<Integer> max, min;

    public MedianFinder() {
        max = new PriorityQueue<>((x, y) -> y - x);
        min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.add(min.poll());
        }
    }

    public double findMedian() {
        return max.size() > min.size() ? max.peek() : (max.peek() + min.peek()) / 2.0;

    }
}
