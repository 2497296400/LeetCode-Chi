package Top集合.课程表II;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] cur = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(solution.findOrder(4, cur)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }
        int[] cur = new int[numCourses];
        for (int[] ints : prerequisites) {
            cur[ints[0]]++;
            g.get(ints[1]).add(ints[0]);
        }
        int len = 0;
        Queue<Integer> queue = new LinkedList<>();
       for(int i = 0;i<cur.length;i++){
           if(cur[i]==0){
               queue.add(i);
           }
       }
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[numCourses];
        len = 0;
        while (!queue.isEmpty()) {
            Integer curF = queue.poll();
            if (!set.contains(curF)) {
                ans[len++] = curF;
                set.add(curF);
                for (Integer integer : g.get(curF)) {
                    if (--cur[integer] == 0) {
                        queue.add(integer);
                    }
                }
            }
        }
        return len!=ans.length?new int[] {}:ans;
    }
}
