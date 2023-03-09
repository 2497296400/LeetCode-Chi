package 丑数系列.第k个数;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getKthMagicNumber(251));
        System.out.println(solution.cur(251));
    }

    public int getKthMagicNumber(int k) {
        int[] res = new int[k];
        res[0] = 1;
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        for (int i = 1; i < k; i++) {
            int cur = Math.min(res[p3] * 3, Math.min(res[p5] * 5, res[p7] * 7));
            if (cur % 3 == 0) {
                p3++;
            }
            if (cur % 5 == 0) {
                p5++;
            }
            if (cur % 7 == 0) {
                p7++;
            }
            res[i] = cur;
        }
        return res[k - 1];
    }


    public int cur(int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> c = new PriorityQueue<>();
        int[] arr = {3, 5, 7};
        priorityQueue.add(1);
        Set<Integer> set = new HashSet<>();
        int cur = 0;
        for (int i = 0; i < k; i++) {
            Integer poll = priorityQueue.poll();
            c.add(poll);
            cur = poll;
            for (int i1 : arr) {
                if (!set.contains(i1 * poll)) {
                    set.add(i1 * poll);
                    priorityQueue.add(i1 * poll);
                }
            }
        }
        System.out.println(c + " " + priorityQueue);
        return cur;
    }

}
