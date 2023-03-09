package 每日一题系列.每日一题十一月.获取所有钥匙的最短路径;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] x = {1, 0, 0, -1};
    int[] y = {0, 1, -1, 0};

    public static void main(String[] args) {
        Solution solution = new Solution();
//        ["@.a..","###.#","b.A.B"]
//["@..aA","..B#.","....b"]
//["@Aa"]
        String[] string = {"@abcdeABCDEFf"};
        System.out.println(solution.shortestPathAllKeys(string));
    }

    public int shortestPathAllKeys(String[] grid) {
        char[][] g = new char[grid[0].length()][grid.length];
        int len = 0;
        int sum = 0;
        int stratX = 0;
        int stratY = 0;
        for (String s : grid) {
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (Character.isLowerCase(array[i])) {
                    sum |= 1 << ('h' - array[i]);
                }
                if (array[i] == '@') {
                    stratX = i;
                    stratY = len;
                }
                g[i][len] = array[i];
            }
            len++;
        }
        int allKey = sum;
        Data node = new Data(stratX, stratY, 0);
        Queue<Data> queue = new LinkedList<>();
        queue.add(node);
        int curLen = 0;
        boolean[][][] vis = new boolean[g.length][g[0].length][allKey + 1];
        while (!queue.isEmpty()) {
            int clen = queue.size();
            for (int i = 0; i < clen; i++) {
                Data cur = queue.poll();
                int curX = cur.X;
                int curY = cur.Y;
                if (cur.key == allKey) {
                    return curLen;
                }
                toCheck(curX, curY, g, cur.key, queue, vis);
            }
            curLen++;
        }
        return -1;
    }

    private void toCheck(int curX, int curY, char[][] g, int key, Queue<Data> queue, boolean[][][] vis) {
        for (int i = 0; i < 4; i++) {
            int cx = curX + x[i];
            int cy = curY + y[i];
            int k = key;
            if (cx < 0 || cx >= g.length || cy < 0 || cy >= g[0].length || g[cx][cy] == '#' || vis[cx][cy][k]) continue;

            if (Character.isLowerCase(g[cx][cy])) {
                k |= 1 << ('h' - g[cx][cy]);
            }
            if (Character.isUpperCase(g[cx][cy])) {
                if ((k & (1 << ('H' - g[cx][cy]))) == 0) {
                    continue;
                }
            }
            vis[cx][cy][k] = true;
            queue.add(new Data(cx, cy, k));
        }
    }
}

class Data {
    int X;
    int Y;
    int key;

    public Data(int x, int y, int key) {
        X = x;
        Y = y;
        this.key = key;
    }
}
