package 每日一题系列.每日一题七月.设置交集大小至少为2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][]ints={{2,10},{3,7},{3,15},{4,11},{6,12},{6,16},{7,8},{7,11},{7,15},{11,12}};
        System.out.println(solution.intersectionSizeTwo(ints));
    }
    public int intersectionSizeTwo(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        System.out.println(Arrays.deepToString(intervals));
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] interval : intervals) {
            int start=interval[0];
            int end=interval[1];
            toCheck(set, start, end);
        }
        //System.out.println(set);
        return set.size();
    }

    private void toCheck(TreeSet<Integer> set, int start, int end) {
        Integer moreThenStart = set.ceiling(start);
        Integer lessThenEnd = set.floor(end);
        if (moreThenStart == null||lessThenEnd==null) {
            set.add(end - 1);
            set.add(end);
        } else if (moreThenStart.equals(lessThenEnd)) {
            while (end >= start) {
                if (set.add(end--)){
                    break;
                }
            }
        }
    }
}
