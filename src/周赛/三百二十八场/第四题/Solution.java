package 周赛.三百二十八场.第四题;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    long curMax = 0L;
    public long maxOutput(int n, int[][] edges, int[] price) {
        List<Integer>[] grip = new List[n];
        for (int i = 0; i < n; i++) {
            grip[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int f = edges[i][0];
            int s = edges[i][1];
            grip[f].add(s);
            grip[s].add(f);
        }
        dfs(0, -1, grip, price);
        return curMax;
    }

    private Info dfs(int cur, int father, List<Integer>[] grip, int[] price) {
        long msf = price[cur];
        long mss = 0;
        for (Integer note : grip[cur]) {
            if (note == father) {
                continue;
            }
            Info info = dfs(note, cur, grip, price);
            curMax = Math.max( curMax , Math.max(msf+ info.lacMax, mss+ info.comMax));
            msf = Math.max(msf, info.comMax+price[cur]);
            mss = Math.max(mss, info.lacMax+price[cur]);
        }
        return new Info(msf, mss);
    }
}

class Info {
    long comMax;
    long lacMax;

    public Info(long comMax, long lacMax) {
        this.comMax = comMax;
        this.lacMax = lacMax;
    }
}
