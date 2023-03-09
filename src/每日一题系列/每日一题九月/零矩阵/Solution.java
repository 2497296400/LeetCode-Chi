package 每日一题系列.每日一题九月.零矩阵;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public void setZeroes(int[][] matrix) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (map.containsKey(i)) {
                        map.get(i).add(j);
                    } else {
                        set.add(j);
                        map.put(i, set);
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                if (set.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                if (map.containsKey(i)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
