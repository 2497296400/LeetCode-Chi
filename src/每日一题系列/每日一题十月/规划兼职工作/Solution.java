package 每日一题系列.每日一题十月.规划兼职工作;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    int[] st;
    int[] ed;
    int[] pr;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sr = {1, 2, 2, 3};
        int[] er = {2, 5, 3, 4};
        int[] ps = {3, 4, 1, 2};
        System.out.println(solution.jobScheduling(sr, er, ps));
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Data[] data = new Data[startTime.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Data(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(data, Comparator.comparingInt(o -> o.sr));
        st = new int[data.length];
        ed = new int[data.length];
        pr = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            st[i] = data[i].sr;
            ed[i] = data[i].er;
            pr[i] = data[i].tr;
        }
        int dp[] = new int[data.length];
        Arrays.fill(dp, -1);
        return fun(0, dp);
    }

    private int fun(int cur, int[] dp) {
        if (cur == -1 || cur == st.length) {
            return 0;
        }
        if (dp[cur] != -1) {
            return dp[cur];
        }
        int next = find(cur, ed[cur]);
        int p1 = fun(next, dp) + pr[cur];
        int p2 = fun(cur + 1, dp);
        dp[cur] = Math.max(p1, p2);
        return Math.max(p1, p2);
    }

    private int find(int cur, int i) {
        int l = cur;
        int r = st.length;
        int flag = -1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (st[mid] < i) {
                l = mid + 1;
            } else {
                flag = mid;
                r = mid;
            }
        }
        return flag;
    }
}

class Data {
    int sr;
    int er;
    int tr;

    public Data(int sr, int er, int tr) {
        this.sr = sr;
        this.er = er;
        this.tr = tr;
    }
}
