package 灵神总结周赛.图论.给定条件下构造矩阵;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g1 = LeetCodeUtils.getIntTow("[[1,2],[3,2]]");
        int[][] g2 = LeetCodeUtils.getIntTow("[[1,2],[3,2]]");
        System.out.println(Arrays.deepToString(solution.buildMatrix(3, g1, g2)));
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer>[] g1 = new List[k + 1];
        int[] r1 = new int[k + 1];
        Arrays.setAll(g1, ArrayList<Integer>::new);
        List<Integer>[] g2 = new List[k + 1];
        Arrays.setAll(g2, ArrayList<Integer>::new);
        int[] r2 = new int[k + 1];
        for (int[] condition : colConditions) {
            g1[condition[0]].add(condition[1]);
            r1[condition[1]]++;
        }
        for (int[] condition : rowConditions) {
            g2[condition[0]].add(condition[1]);
            r2[condition[1]]++;
        }
        Integer[] line = topology(g1, r1);
        Integer[] row = topology(g2, r2);
        if (line.length < k || row.length < k) {
            return new int[][]{};
        }
        int[][] g = new int[k][k];
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < line.length; j++) {
                if (Objects.equals(row[i], line[j])) {
                    g[i][j] = row[i];
                }
            }
        }
        return g;
    }

    private Integer[] topology(List<Integer>[] g, int[] r) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < r.length; i++) {
            if (r[i] == 0) {
                queue.add(i);
                set.add(i);
            }
        }
        if (queue.isEmpty()) {
            return null;
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            arrayList.add(poll);
            for (Integer next : g[poll]) {
                if (!set.contains(next) && --r[next] == 0) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
        return arrayList.toArray(Integer[]::new);
    }
}
