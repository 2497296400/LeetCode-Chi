package 每日一题系列.每日一题一月.求出MK平均值;

import java.util.*;

public class MKAverage {

    TreeMap<Integer, Integer> map;
    int m;
    int k;
    Queue<Integer> queue;

    long curSum = 0L;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.queue = new LinkedList<>();
        this.map = new TreeMap<>();
    }

    public void addElement(int num) {
        if (queue.size() == m) {
            Integer cur = queue.poll();
            if (map.get(cur) == 1) {
                map.remove(cur);
            } else {
                map.put(cur, map.getOrDefault(cur, 0) - 1);
            }
            curSum -= cur;
        }
        map.put(num, map.getOrDefault(num, 0) + 1);
        queue.add(num);
        curSum += num;
    }

    public int calculateMKAverage() {
        if(queue.size()<m){
            return -1;

        }
        return (int) ((curSum - getSum(map)) / (m-2*k));
    }

    private long getSum(TreeMap<Integer, Integer> map) {
        Set<Map.Entry<Integer, Integer>> minSet = map.entrySet();
        Set<Map.Entry<Integer, Integer>> set = map.descendingMap().entrySet();

        int curSumIndex = k;
        long getAllSum = 0L;
        for (Map.Entry<Integer, Integer> integerEntry : minSet) {
            Integer key = integerEntry.getKey();
            Integer value = integerEntry.getValue();
            if (curSumIndex > value) {
                getAllSum += (long) key * value;
            } else {
                getAllSum += (long) key * curSumIndex;
                break;
            }
            curSumIndex -= value;
        }
        curSumIndex = k;
        for (Map.Entry<Integer, Integer> entry : set) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (curSumIndex > value) {
                getAllSum += (long) key * value;
            } else {
                getAllSum += (long) key * curSumIndex;
                break;
            }
            curSumIndex -= value;
        }
        return getAllSum;
    }
}
