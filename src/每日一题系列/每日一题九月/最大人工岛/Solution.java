package 每日一题系列.每日一题九月.最大人工岛;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int ans = 0;
    int col;
    int row;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1, 0}, {0, 1}};
        System.out.println(solution.largestIsland(grid));
    }

    public int largestIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int size = row * col;

        Union union = new Union(size);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (i + 1 < row && grid[i + 1][j] == 1) {
                        union.union(index(i, j), index(i + 1, j));
                    }
                    if (j + 1 < col && grid[i][j + 1] == 1) {
                        union.union(index(i, j), index(i, j + 1));
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    int temp = 1;
                    Set<Integer> set = new TreeSet<>();
                    for (int cur = 0; cur < 4; cur++) {
                        int curX = dx[cur] + i;
                        int curY = dy[cur] + j;
                        if (curX < 0 || curY < 0 || curX >= row || curY >= col || grid[curX][curY] == 0) {
                            continue;
                        }
                        int idx = index(curX, curY);
                        if (set.contains(union.find(idx))) {
                            continue;
                        }
                        temp += union.size[union.find(idx)];
                        set.add(union.find(idx));
                    }
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }

    private int index(int r, int c) {
        return r * col + c;
    }

    private class Union {
        int[] parents;
        int[] size;

        public Union(int size) {
            parents = new int[size];
            this.size = new int[size];
            for (int i = 0; i < size; i++) {
                parents[i] = i;
                this.size[i] = 1;
            }
        }

        public void union(int first, int second) {
            first = find(first);
            second = find(second);
            if (second != first) {
                if (size[first] > size[second]) {
                    parents[second] = first;
                    size[first] += size[second];
                } else {
                    parents[first] = second;
                    size[second] += size[first];
                }
            }
            ans = Math.max(ans, Math.max(size[second], size[first]));
        }

        public int find(int val) {
            if (parents[val] != val) {
                parents[val] = find(parents[val]);
            }
            return parents[val];
        }
    }

}

