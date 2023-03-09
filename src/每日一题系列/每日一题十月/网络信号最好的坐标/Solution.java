package 每日一题系列.每日一题十月.网络信号最好的坐标;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0, 1, 2}, {2, 1, 2}, {1, 0, 2}, {1, 2, 2}};
        System.out.println(Arrays.toString(solution.bestCoordinate(arr, 1)));
    }

    public int[] bestCoordinate(int[][] towers, int radius) {
        int max = Integer.MIN_VALUE;
        int[] arr = new int[2];
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                int sum = 0;
                for (int[] ints : towers) {
                    if (getD(i, j, ints[0], ints[1]) <= radius) {
                        int cur = (int) (ints[2] / (1 + getD(i, j, ints[0], ints[1])));
                        sum += cur;
                    }
                }
                System.out.println(sum);
                if (sum > max) {
                    arr[0] = i;
                    arr[1] = j;
                }
                if (sum == max) {
                    if (arr[0] > i) {
                        arr[0] = j;
                        arr[1] = i;
                    } else if (arr[0] == i && arr[1] > j) {
                        arr[0] = i;

                        arr[1] = j;
                    }
                }
                max = Math.max(sum, max);
            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO 自动生成的方法存根
                return o2-o1;
            }
        });

        return arr;
    }

    public double getD(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
