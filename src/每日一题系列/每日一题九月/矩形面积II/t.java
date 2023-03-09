package 每日一题系列.每日一题九月.矩形面积II;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class t {
    public static void main(String[] args) {
        t t = new t();
        int[][] arr = {{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}};
        System.out.println(t.rectangleArea(arr));
    }

    public int rectangleArea(int[][] rectangles) {
        int[] curX = process(rectangles, 0, 2);
        int[] curY = process(rectangles, 1, 3);
        long ans = 0;
        for (int i = 0; i < curX.length; i++) {
            int[] help = new int[curY.length + 1];
            for (int j = 0; j < rectangles.length; j++) {
                if (i >= rectangles[j][0] && i < rectangles[j][2]) {
                    help[rectangles[j][1]]++;
                    help[rectangles[j][3]]--;
                }
            }
            long width = 0;
            if (help[0] > 0) {
                ans += (long) (curX[i + 1] - curX[i]) * (curY[1] - curY[0]);
            }
            for (int j = 1; j < curY.length; j++) {
                help[j] += help[j - 1];
                if (help[j] > 0) {
                    ans += (long) (curX[i + 1] - curX[i]) * (curY[j + 1] - curY[j]);
                }
            }
        }
        return (int) (ans % (1e9 + 7));
    }

    private int[] process(int[][] rectangles, int first, int seoncd) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] rectangle : rectangles) {
            set.add(rectangle[first]);
            set.add(rectangle[seoncd]);
        }
        int[] ans = new int[set.size()];
        HashMap<Integer, Integer> map = new HashMap<>();
        int curlen = 0;
        for (Integer integer : set) {
            ans[curlen] = integer;
            map.put(integer, curlen++);
        }
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i][first] = map.get(rectangles[i][first]);
            rectangles[i][seoncd] = map.get(rectangles[i][seoncd]);
        }
        return ans;
    }
}

