package 每日一题系列.每日一题一月.矩阵转换后的秩;

import java.util.*;

public class Solution {
    int[] father;
    int SIZE;
    int MAX;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{2, 3, 1}, {9, 4, 5}, {3, 4, 2}};
        System.out.println(Arrays.deepToString(solution.matrixRankTransform(arr)));
    }

    void Union(int i, int j) {
        father[find(i)] = find(j);
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        father = new int[matrix.length * matrix[0].length];
        MAX = matrix.length * matrix[0].length;
        int[][] value = new int[matrix.length][matrix[0].length];
        SIZE = matrix[0].length;
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
        List<Integer[]> cowSort = new ArrayList<>();
        List<Integer[]> rolSort = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            Integer[] temp = new Integer[matrix[0].length];
            toFun(cowSort, i, temp, matrix[i]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int[] temp = new int[matrix.length];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = matrix[j][i];
            }
            Integer[] c = new Integer[matrix.length];
            toFuns(rolSort, i, c, temp);
        }
        List<Integer>[] grid = new List[MAX];
        int[] penetration = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            grid[i] = new ArrayList<>();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                Integer nextKey = cowSort.get(i)[j];
                int s = matrix[i][nextKey];
                Integer firstKey = cowSort.get(i)[j - 1];
                int f = matrix[i][firstKey];
                if (f != s) {
                    grid[find(curIndex(i, firstKey))].add(find(curIndex(i, nextKey)));
                    penetration[find(curIndex(i, nextKey))]++;
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                Integer nextKye = rolSort.get(i)[j];
                Integer firstKey = rolSort.get(i)[j - 1];
                int s = matrix[nextKye][i];
                int f = matrix[firstKey][i];
                if (f != s) {
                    grid[find(curIndex(firstKey, i))].add(find(curIndex(nextKye, i)));
                    penetration[find(curIndex(nextKye, i))]++;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] rank = new int[MAX];
        for (int i = 0; i < penetration.length; i++) {
            if (penetration[i] == 0) {
                queue.add(i);
                rank[i] = 1;
            }
        }
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Integer curIndex : grid[now]) {
                if (--penetration[curIndex] == 0) {
                    queue.add(curIndex);
                    rank[curIndex] = Math.max(rank[curIndex], rank[now] + 1);
                }
            }
        }
        
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                value[i][j] = rank[find(curIndex(i, j))];
            }
        }
        return value;
    }

    private void toFun(List<Integer[]> list, int cur, Integer[] temp, int[] matrix) {
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i;
        }
        Arrays.sort(temp, Comparator.comparingInt(o -> matrix[o]));
        for (int j = 1; j < temp.length; j++) {
            if (matrix[temp[j - 1]] == matrix[temp[j]]) {
                Union(curIndex(cur, temp[j - 1]), curIndex(cur, temp[j]));
            }
        }
        list.add(temp);
    }

    private void toFuns(List<Integer[]> list, int cur, Integer[] temp, int[] matrix) {
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i;
        }
        Arrays.sort(temp, Comparator.comparingInt(o -> matrix[o]));
        for (int j = 1; j < temp.length; j++) {
            if (matrix[temp[j - 1]] == matrix[temp[j]]) {
                Union(curIndex(temp[j - 1], cur), curIndex(temp[j], cur));
            }
        }
        list.add(temp);
    }

    public int curIndex(int i, int j) {
        return i * SIZE + j;
    }

    public int find(int x) {
        if (father[x] != x) {
            father[x] = find(father[x]);
        }
        return father[x];
    }
}