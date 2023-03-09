package 每日一题系列.每日一题十二月.移动所有球到每个盒子所需的最小操作数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.minOperations("001011")));
    }

    public int[] minOperations(String boxes) {
        char[] cur = boxes.toCharArray();
        int[] ans = new int[cur.length];
        int[] pre = new int[cur.length + 1];
        int[] las = new int[cur.length + 1];
        int temp = 0;
        for (int i = 1; i < cur.length; i++) {
            temp += cur[i - 1] == '1' ? 1 : 0;
            pre[i] += pre[i - 1] + temp;
        }
        temp = 0;
        for (int i = cur.length - 1; i >= 0; i--) {
            temp += cur[i] == '1' ? 1 : 0;
            las[i] += las[i + 1] + temp;
        }
        for (int i = 0; i < cur.length; i++) {
            ans[i] = pre[i] + las[i + 1];
        }
        return ans;
    }
}

