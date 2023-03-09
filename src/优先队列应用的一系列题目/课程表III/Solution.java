package 优先队列应用的一系列题目.课程表III;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        int curTime = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int[] cours : courses) {
            int f = cours[0];
            int s = cours[1];
            if (curTime + f <= s) {
                curTime += f;
                queue.add(f);
            } else if (!queue.isEmpty() && queue.peek() >=  f) {
                Integer poll = queue.poll();
                curTime -= poll;
                curTime += f;
                queue.add(f);
            }
        }
        return queue.size();
    }
}
