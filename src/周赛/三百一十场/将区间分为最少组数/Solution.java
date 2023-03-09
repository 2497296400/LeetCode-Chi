package 周赛.三百一十场.将区间分为最少组数;

import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = {{1, 1}, {1, 1}, {1, 1},{2,2},{2,2}};
        System.out.println(solution.minGroups(ints));
    }

    public int minGroups(int[][] intervals) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int[] interval : intervals) {
            treeMap.put(interval[0], treeMap.getOrDefault(interval[0], 0) + 1);
                treeMap.put(interval[1]+1, treeMap.getOrDefault(interval[1]+1, 0) - 1);
        }
        int curSum = 0;
        int curMax = 0;
        for (Integer value : treeMap.values()) {
            curSum += value;
            curMax = Math.max(curSum, curMax);
        }
        return curMax;
    }
}
