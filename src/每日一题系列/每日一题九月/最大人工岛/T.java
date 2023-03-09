package 每日一题系列.每日一题九月.最大人工岛;

import java.util.HashSet;

public class T {
    int col;
    int row;
    int ans = 1;

    public int largestIsland(int[][] grid) {
        col = grid[0].length;
        row = grid.length;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        Union union = new Union(col * row);
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
                    HashSet<Integer>set=new HashSet<>();
                    int temp = 1;
                    for (int cur = 0; cur < 4; cur++) {
                        int curX = dx[cur] + i;
                        int curY = dy[cur] + j;
                        if (curX >= row || curY >= col || curY < 0 || curX < 0 || grid[curX][curY] == 0) {
                            continue;
                        }
                        int curIndex = index(curX, curY);
                        if (set.contains(union.find(curIndex))) {
                            continue;
                        }
                        temp += union.size[union.find(curIndex)];
                        set.add(union.find(curIndex));
                    }
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }

    public int index(int x, int y) {
        return x * col + y;
    }

    class Union {
        int[] father;
        int[] size;

        public Union(int size) {
            father = new int[size];
            this.size = new int[size];
            for (int i = 0; i < size; i++) {
                father[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int val) {
            if (father[val] != val) {
                father[val] = find(father[val]);
            }
            return father[val];
        }

        public void union(int first, int second) {
            first = find(first);
            second = find(second);
            if (first != second) {
                if (size[first] <= size[second]) {
                    father[first] = second;
                    size[second] += size[first];
                } else {
                    father[second] = first;
                    size[first] += size[second];
                }
            }
            ans = Math.max(ans, Math.max(size[first], size[second]));
        }
    }
}
