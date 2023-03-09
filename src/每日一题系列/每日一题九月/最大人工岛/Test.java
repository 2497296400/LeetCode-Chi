package 每日一题系列.每日一题九月.最大人工岛;
import java.util.HashMap;
import java.util.HashSet;
//超时
public class Test {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int ans = 1;

    public static void main(String[] args) {
        Test test = new Test();
        int[][] grid = {{0, 1}, {1, 1}};
        System.out.println(test.largestIsland(grid));
    }

    public int largestIsland(int[][] grid) {
        int col = grid[0].length, row = grid.length;
        Union union = new Union(col, row);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Data first = new Data(i, j);
                if (grid[i][j] == 1) {
                    if (i + 1 < row && grid[i + 1][j] == 1) {
                        Data second = new Data(i + 1, j);
                        union.union(first, second);
                    }
                    if (j + 1 < col && grid[i][j + 1] == 1) {
                        Data second = new Data(i, j + 1);
                        union.union(first, second);
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    int curSum = 1;
                    HashSet<Data> set = new HashSet<>();
                    for (int cur = 0; cur < 4; cur++) {
                        int curX = dx[cur] + i;
                        int curY = dy[cur] + j;
                        if (curX < 0 || curY < 0 || curX >= row || curY >= col || grid[curX][curY] == 0) {
                            continue;
                        }
                        Data data = new Data(curX, curY);
                        if (set.contains(union.find(data))) {
                            continue;
                        }
                        curSum += union.size.get(union.find(data));
                        set.add(union.find(data));
                    }
                    ans = Math.max(ans, curSum);
                }
            }
        }
        return ans;
    }

    private class Data {
        int curX;
        int curY;

        public Data(int curX, int curY) {
            this.curX = curX;
            this.curY = curY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data = (Data) o;

            if (curX != data.curX) return false;
            return curY == data.curY;
        }

        @Override
        public int hashCode() {
            int result = curX;
            result = 31 * result + curY;
            return result;
        }
    }

    public class Union {
        public HashMap<Data, Data> father;
        public HashMap<Data, Integer> size;

        public Union(int col, int row) {
            father = new HashMap<>();
            size = new HashMap<>();

            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    Data data = new Data(i, j);
                    father.put(data, data);
                    size.put(data, 1);
                }
            }
        }
        public void union(Data first, Data second) {
            first = find(first);
            second = find(second);
            if (first != second) {
                if (size.get(first) > size.get(second)) {
                    father.put(second, first);
                    size.put(first, size.get(first) + size.get(second));
                } else {
                    father.put(first, second);
                    size.put(second, size.get(first) + size.get(second));
                }
            }
            ans = Math.max(ans, Math.max(size.get(first), size.get(second)));
        }

        public Data find(Data data) {
            if (father.get(data) != data) {
                father.put(data, find(father.get(data)));
            }
            return father.get(data);
        }
    }
}
