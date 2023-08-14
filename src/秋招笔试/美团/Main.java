package 秋招笔试.美团;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    //代码
    static int MOD = (int) (1e9 + 7);
    static long k;

    public static void main(String[] args) throws IOException {
        int m = nextInt();
        k = nextLong();
        List<Integer>[] list = new List[m + 1];
        for (int i = 0; i <= m; i++) {
            list[i] = new ArrayList<>(2);
        }
        for (int i = 0; i < m - 1; i++) {
            int u = nextInt();
            int v = nextInt();
            list[u].add(v);
            list[v].add(u);
        }
        int[] deep = new int[m + 1];
        long preAsn = 0;
        dfs(1, 0, list, deep);
        for (int i = 1; i < deep.length; i++) {
            if (deep[i] <= k) {
                preAsn++;
            }
        }
        ArrayList<Integer> preNode = new ArrayList<>();
        for (int i = 1; i < list.length; i++) {
            if (list[i].size() == 0 && deep[i] < k) {
                preNode.add(i);
            }
        }
        for (Integer integer : preNode) {
            preAsn += k - deep[integer];
        }
        System.out.println(preAsn);
    }

    static long ans = 0;

    private static void dfs(int u, int curDeep, List<Integer>[] list, int[] deep) {
        deep[u] = curDeep;
        if (curDeep <= k) {
            ans++;
        }
        if (list[u].size() == 0) {
            ans += Math.max(0, k - curDeep);
            return;
        }
        for (Integer v : list[u]) {
            dfs(v, curDeep + 1, list, deep);
        }
    }

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    private static boolean isT(long nextInt) {
        if (nextInt <= 3) {
            return nextInt > 1;
        }

        if (nextInt % 6 != 1 && nextInt % 6 != 5) {
            return false;
        }
        for (int i = 5; i <= Math.sqrt(nextInt); i += 6) {
            if (nextInt % i == 0 || nextInt % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }


}

class IndexTreeRange {
    int[] sum1;
    int[] sum2;
    int N;

    public IndexTreeRange(int n) {
        sum1 = new int[n + 1];
        sum2 = new int[n + 1];
        N = n;
    }

    public int lowbit(int x) {
        return x & (-x);
    }

    public void update(int index, int value) {
        int preIndex = index;
        while (index <= N) {
            sum1[index] += value;
            sum2[index] += value * (preIndex - 1);
            index += lowbit(index);
        }
    }

    public void update(int l, int r, int v) {
        update(l, v);
        update(r + 1, -v);
    }

    public int query(int l, int r) {
        return query(r) - query(l - 1);
    }

    private int query(int index) {
        int res = 0;
        int preIndex = index;
        while (index > 0) {
            res += sum1[index] * preIndex - sum2[index];
            index -= lowbit(index);
        }
        return res;
    }
}

class IndexTreeMax {
    int N;
    int[] tree;
    int[] fuzhu;

    public IndexTreeMax(int n) {
        N = n;
        tree = new int[n + 1];
        fuzhu = new int[n + 1];
    }

    public int lowbit(int x) {
        return x & (-x);
    }

    public void update(int index, int value) {
        tree[index] = fuzhu[index] = value;
        while (index <= N) {
            tree[index] = Math.max(tree[index], value);
            index += lowbit(index);
        }
    }

    public int query(int l, int r) {
        int ans = 0;
        while (r >= l) {
            ans = Math.max(ans, fuzhu[r]);
            for (r--; r - lowbit(r) >= l; r -= lowbit(r)) {
                ans = Math.max(ans, tree[r]);
            }
        }
        return ans;
    }
}

