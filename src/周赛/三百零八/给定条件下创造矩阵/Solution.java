package 周赛.三百零八.给定条件下创造矩阵;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] row = {{1, 2}, {3 ,2}};
        int[][] col = {{2, 1}, {3, 2}};
        Solution solution = new Solution();
        int[][] ints = solution.buildMatrix(3, row, col);
        System.out.println(Arrays.deepToString(ints));
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<Integer> row = topology(k, rowConditions);
        ArrayList<Integer> col = topology(k, colConditions);
        ArrayList<Integer>arrayList=new ArrayList<>();
        if (row.size() < k || col.size() < k) {
            return  new int [][]{};
        }
        int[][] ans = new int[k][k];
        for (int i = 1; i <= k; i++) {
            ans[row.indexOf(i)][col.indexOf(i)] = i;
        }
        return ans;
    }
    private ArrayList<Integer> topology(int k, int[][] rowConditions) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        int[] in = new int[k + 1];
        for (int i = 1; i <= k + 1; i++) {
            g.add(new ArrayList<Integer>());
        }
        for (int[] rowCondition : rowConditions) {
            int first = rowCondition[0];
            int second = rowCondition[1];
            g.get(first).add(second);
            in[second]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int first = queue.remove();
            res.add(first);
            for (Integer integer : g.get(first)) {
                in[integer]--;
                if (in[integer] == 0) {
                    queue.add(integer);
                }
            }
        }
        return res;
    }
}
