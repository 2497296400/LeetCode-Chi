package 直线上最多的点数;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] nums = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        maxPoints(nums);
    }

    static class Node {
        public Node(HashMap<Double, Integer> hashMap) {
            this.hashMap = hashMap;
        }

        public HashMap<Double, Integer> hashMap = new HashMap<>();
    }
    public static int maxPoints(int[][] points) {
        ArrayList<ArrayList<int[]>> lists = new ArrayList<>();
        Node[] node = new Node[points.length];
        if (points.length < 2) {
            return points.length;
        }
        for (int i = 0; i < points.length; i++) {
            node[i] = new Node(new HashMap<>());
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    double temp = isSame(points[i], points[j]);
                    if (node[i].hashMap.containsKey(temp)) {
                        node[i].hashMap.put(temp, node[i].hashMap.get(temp) + 1);
                    } else {
                        node[i].hashMap.put(temp, 2);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Set<Double> doubles = node[i].hashMap.keySet();
            for (Double aDouble : doubles) {
                max = Math.max(max, node[i].hashMap.get(aDouble));
            }
        }
        System.out.println(max);
        return max;
    }

    private static double isSame(int[] point, int[] point1) {
        double x1 = point[0], y1 = point[1];
        double x2 = point1[0], y2 = point1[1];
        if (x1 - x2 == 0) {
            return Integer.MAX_VALUE;
        } else if (y2 - y1 == 0) {
            return 0;
        } else {
            return (y2 - y1) / (x2 - x1);
        }
    }
}
