package 力扣工具类.并查集板子;

public class Solution {

}

class Union {
    int[] fa;
    int[] sz;
    public Union(int N) {
        for (int i = 0; i < N; i++) {
            fa[i] = i;
            sz[i] = 1;
        }
    }
    public void union(int f, int s) {
        f = find(f);
        s = find(s);
        if (f != s) {
            if (sz[f] < sz[s]) {
                sz[f] += sz[s];
                fa[s] = f;
            }
        } else {
            sz[s] += sz[f];
            fa[s] = f;
        }
    }
    private int find(int cur) {
        if (fa[cur] != cur) {
            fa[cur] = find(fa[cur]);
        }
        return fa[cur];
    }
}
