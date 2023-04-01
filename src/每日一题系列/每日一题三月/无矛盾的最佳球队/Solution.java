package 每日一题系列.每日一题三月.无矛盾的最佳球队;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] a = {1, 3, 7, 3, 2, 4, 10, 7, 5};
        int[] s = {4, 5, 2, 1, 1, 2, 4, 1, 4};
        System.out.println(solution.bestTeamScore(a, s));
        System.out.println(solution.bestTeamSc(a, s));
    }

    int[] tree;
    int N;

    public void add(int index, int target) {
        for (int i = index; i <= N; i += (index & (-index))) {
            tree[i] = Math.max(tree[i], target);
        }
    }

    public int query(int index) {
        int max = 0;
        while (index > 0) {
            max = Math.max(max, tree[index]);
            index -= index & (-index);
        }
        return max;
    }

    public int bestTeamSc(int[] sc, int[] ag) {
        tree = new int[1001];
        N = 1000;
        
        Data data[] = new Data[sc.length];
        for (int i = 0; i < sc.length; i++) {
            data[i] = new Data(sc[i], ag[i]);
        }
        Arrays.sort(data, (o1, o2) -> {
            return o1.s == o2.s ? o1.f - o2.f : o1.s - o2.s;
        });
        for (int i = 0; i < sc.length; i++) {
            add(data[i].s, data[i].f + query(data[i].s));
        }
        return query(1000);
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        Data data[] = new Data[scores.length];
        for (int i = 0; i < scores.length; i++) {
            data[i] = new Data(scores[i], ages[i]);
        }
        Arrays.sort(data, (o1, o2) -> {
            return o1.s == o2.s ? o1.f - o2.f : o1.s - o2.s;
        });
        Integer[][] dp = new Integer[scores.length][scores.length];
        return fun(data, -0, -1, dp);
    }

    private int fun(Data[] data, int i, int pre, Integer[][] dp) {
        if (i == data.length) {
            return 0;
        }
        int ans = 0;
        if (pre != -1 && dp[i][pre] != null) {
            return dp[i][pre];
        }
        for (int cur = i; cur < data.length; cur++) {
            if (pre == -1 || data[cur].f >= data[pre].f) {
                ans = Math.max(ans, fun(data, cur + 1, pre, dp) + data[cur].f);
            }
        }
        if (pre != -1) {
            dp[i][pre] = ans;
        }
        return ans;
    }
}

class Data {
    int f;
    int s;

    public Data(int f, int s) {
        this.f = f;
        this.s = s;
    }
}
