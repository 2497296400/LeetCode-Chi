package 每日一题系列.每日一题八月.正方形中的最多点数;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] points = {{2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}};
        String s = "abdca";
        Solution solution = new Solution();
        System.out.println(solution.maxPointsInsideSquare(points, s));
    }

    public int maxPointsInsideSquare(int[][] points, String s) {
        Integer[] charValue = new Integer[26];
        boolean[] charExist = new boolean[26];
        Arrays.fill(charValue, Integer.MAX_VALUE);
        PriorityQueue[] listPQ = new PriorityQueue[26];
        for (int i = 0; i < 26; i++) {
            listPQ[i] = new PriorityQueue<Long>();
        }
        int len = points.length;
        int  curMin = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int  value =  Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            listPQ[s.charAt(i) - 'a'].add(value);
        }
        for (int i = 0; i < 26; i++) {
            if (listPQ[i].size() == 0) {
                continue;
            }
            if (listPQ[i].size() == 1) {
                charValue[i] = (int ) listPQ[i].poll();
                charExist[i] = true;
            } else {
                int  one = (int ) listPQ[i].poll();
                int  tow = (int ) listPQ[i].poll();
                if (one == tow) {
                    charExist[i] = false;
                }
                if (one < tow) {
                    charValue[i] = one;
                    charExist[i] = true;
                }
                curMin = Math.min(curMin, tow);
            }
        }
        int ans = 0;
        List<SortData> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new SortData(charValue[i], charExist[i]));
        }
        list.sort((o1, o2) -> {
            if (o1.value == o2.value) {
                return o1.exist ? 1 : -1;
            }
            return o1.value > o2.value ? 1 : -1;
        });
        for (SortData sortData : list) {
            if (sortData.exist) {
                if (sortData.value >= curMin) {
                    break;
                }
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}

class SortData {
    int  value;
    boolean exist;

    public SortData(int  value, boolean exist) {
        this.value = value;
        this.exist = exist;
    }
}
