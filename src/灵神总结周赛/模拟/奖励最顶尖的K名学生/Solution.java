package 灵神总结周赛.模拟.奖励最顶尖的K名学生;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        
    }
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback,
                                     String[] report, int[] student_id, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            if (o2[0] == o1[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        }));
        HashSet<String> p = new HashSet<>(List.of(positive_feedback));
        HashSet<String> n = new HashSet<>(List.of(negative_feedback));
        for (int i = 0; i < report.length; i++) {
            String cur = report[i];
            int curAns = toGet(cur, p, n);
            priorityQueue.add(new int[]{curAns, student_id[i]});
        }
        List<Integer> arr = new ArrayList<>(k);
        for (int i = 0;i< k; i++) {
            arr.add(priorityQueue.poll()[1]);
        }
        return arr;
    }

    private int toGet(String cur, HashSet<String> p, HashSet<String> n) {
        int ans = 0;
        String[] strings = cur.split(" ");
        for (String string : strings) {
            if (p.contains(string)) {
                ans += 3;
            }else if(n.contains(string)){
                ans-=1;
            }
        }
        return ans;
    }
}
