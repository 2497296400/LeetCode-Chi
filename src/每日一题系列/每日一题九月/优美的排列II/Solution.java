package 每日一题系列.每日一题九月.优美的排列II;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.constructArray(100, 99)));
    }

    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(i);
        }
        int len = 0;
        ans[len++] = 1;
        for (int j = k; j > 0; j--) {
            if (j == 1) {
                for (Integer integer : set) {
                    ans[len++] = integer;
                }
            }
            else {
                    int curData = ans[len - 1];
                    if (set.contains(curData - j)) {
                        ans[len++] = curData - j;
                        set.remove(curData - j);
                    } else if(set.contains(curData+j)){
                        ans[len++] = curData + j;
                        set.remove(curData + j);
                    }
                }
            }
        return ans;
    }
}
