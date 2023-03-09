package 每日一题系列.每日一题九月.矩形面积II;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int [] []arr={{0,0,2,2},{1,0,2,3},{1,0,3,1},{0,0,1000000,1000000}};
        Solution solution = new Solution();
        System.out.println(solution.rectangleArea(arr));
    }
    public final int MOD = (int) (1e9 + 7);

    public int rectangleArea(int[][] rectangles) {
        int[] map1 = compress(rectangles, 0, 2);
        int[] map2 = compress(rectangles, 1, 3);
        long ans = 0;
        for (int i = 0; i < map1.length - 1; i++) {
            int[] count = new int[map2.length +1];
            for (int j = 0; j < rectangles.length; j++) {
                if (i >= rectangles[j][0] && i < rectangles[j][2]) {
                    count[rectangles[j][1]]++;
                    count[rectangles[j][3]]--;
                }
            }
            long width = map1[i + 1] - map1[i];
            if (count[0] > 0) {
                ans += width * (map2[1] - map2[0]);
            }
            for (int j = 1; j < map2.length; j++) {
                count[j] += count[j - 1];
                if (count[j] > 0) {
                    ans += width * (map2[j + 1] - map2[j]);
                }
            }
        }
        return (int) (ans % MOD);
    }

    private int[] compress(int[][] rectangles, int idx1, int idx2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] rectangle : rectangles) {
            set.add(rectangle[idx1]);
            set.add(rectangle[idx2]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[set.size()];
        int curLen = 0;
        for (Integer integer : set) {
            ans[curLen] = integer;
            map.put(integer, curLen);
            curLen++;
        }
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i][idx1] = map.get(rectangles[i][idx1]);
            rectangles[i][idx2] = map.get(rectangles[i][idx2]);
        }
        return ans;
    }
}