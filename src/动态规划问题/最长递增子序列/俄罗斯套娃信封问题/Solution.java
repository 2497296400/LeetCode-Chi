package 动态规划问题.最长递增子序列.俄罗斯套娃信封问题;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[][] env = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int [][] ints={{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};

        int[][] as = {{1, 1}, {1, 1}, {1, 1}};
        System.out.println(maxEnvelopes(as));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int[] ans = porcessEn(envelopes);
        int[] ends = new int[ans.length];
        ends[0] = ans[0];
        int max = 1;
        int endSize = 1;
        for (int i = 1; i < ans.length; i++) {
            int l = 0;
            int r = endSize - 1;
            int findIndex = findProcee(ends, l, r, ans[i]);
            if (findIndex == -1) {
                ends[endSize++] = ans[i];
            } else {
                if (ends[findIndex] > ans[i]) {
                    ends[findIndex] = ans[i];
                }
            }
        }
        return endSize;
    }

    private static int findProcee(int[] ends, int l, int r, int an) {
        int flag = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ends[mid] >= an) {
                flag = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return flag;
    }
    private static int[] porcessEn(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] ans = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            ans[len++] = envelope[1];
        }
        return ans;
    }

}
