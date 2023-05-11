package 周赛.三百三十九场.第三题;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] ar = {4, 1, 5, 3, 3};
        int[] sr = {3, 4, 4, 5, 2};
        System.out.println(solution.miceAndCheese(ar, sr, 3));
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int[][] srr = new int[reward1.length][2];
        for (int i = 0; i < reward1.length; i++) {
            srr[i][0] = reward1[i];
            srr[i][1] = reward2[i];
        }
        Arrays.sort(srr, (o1, o2) -> {
            return (o2[0] - o2[1]) - (o1[0] - o1[1]);
        });
        int ans = 0;
        for (int i = 0; i < reward1.length; i++) {
            if (k > 0) {
                ans += srr[i][0];
                k--;
            } else {
                ans += srr[i][1];
            }
        }
        return ans;
    }
}
