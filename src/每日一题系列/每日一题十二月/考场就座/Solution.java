package 每日一题系列.每日一题十二月.考场就座;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution {

}

class ExamRoom {
    int size;
    PriorityQueue<int[]> queue;
    TreeSet<Integer> set;

    public ExamRoom(int n) {
        this.size = n - 1;
        this.set = new TreeSet<>();
        this.queue = new PriorityQueue<>((o1, o2) -> {
            int f = o1[1] - o1[0];
            int s = o2[1] - o2[0];
            return f / 2 < s / 2 || (f / 2 == s / 2 && o1[1] > o2[1]) ? 1 : -1;
        });
    }

    public int seat() {
        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }
        int l = set.first();
        int r = size - set.last();
        while (set.size() >= 2) {
            int[] cur = queue.peek();
            if (set.contains(cur[0]) && set.contains(cur[1]) && set.higher(cur[0]) == cur[1]) {
                int d = cur[1] - cur[0];
                if (d / 2 <= l || d / 2 < r) {
                    break;
                }
                queue.poll();
                queue.add(new int[]{cur[0], cur[0] + d / 2});
                queue.add(new int[]{cur[0] + d / 2, cur[1]});
                set.add(cur[0] + d / 2);
                return cur[0] + d / 2;
            }
            queue.poll();
        }
        if (l < r) {
            queue.add(new int[]{set.last(), size});
            set.add(size);
            return size;
        } else {
            queue.add(new int[]{0, set.first()});
            set.add(0);
            return 0;
        }
    }

    public void leave(int p) {
        if (p != set.first() && p != set.last()) {
            int pre = set.lower(p);
            int next = set.higher(p);
            queue.add(new int[]{pre,next});
        }
        set.remove(p);
    }
}



