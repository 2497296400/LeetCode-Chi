package 优先队列应用的一系列题目.天际线问题扫描线;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] b = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(solution.getSkyline(b));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> pro = new ArrayList<>();
        for (int[] building : buildings) {
            pro.add(new int[]{building[0], -building[2]});
            pro.add(new int[]{building[1], building[2]});
        }
        pro.sort((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        List<List<Integer>> ans = new ArrayList<>();
        int preHigh = 0;
        priorityQueue.add(0);
        for (int[] ints : pro) {
            int point = ints[0], height = ints[1];
            if (height < 0) {
                priorityQueue.add(-height);
            } else {
                priorityQueue.remove(height);
            }
            int cur = priorityQueue.peek();
            if (cur != preHigh) {
                List<Integer> temp = new ArrayList<>();
                temp.add(point);
                temp.add(cur);
                preHigh = cur;
                ans.add(temp);
            }
        }
        return ans;
    }
}

