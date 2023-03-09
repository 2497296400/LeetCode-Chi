package 每日一题系列.每日一题一月.序列中不同最大公约数的数目;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
    }

    public int GCD(int m, int n) {
        return m == 0 ? n : GCD(n % m, m);
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int curMax = 0;
        for (int num : nums) {
            curMax = Math.max(curMax, num);
        }
        boolean[] vis = new boolean[curMax + 1];
        for (int num : nums) {
            vis[num] = true;
        }
        int ans = 0;
        for (int i = 1; i <= curMax; i++) {
            int curGCD = -1;
            for (int j = i; j <= curMax; j += i) {
                if (vis[j]) {
                    if (curGCD == -1) {
                        curGCD = j;
                    } else {
                        curGCD = GCD(curGCD, j);
                    }
                    if (curGCD == i) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}

