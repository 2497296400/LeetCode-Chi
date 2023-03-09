package 每日一题系列.每日一题九月.拆炸弹;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10, 5, 7, 7, 3, 2, 10, 3, 6, 9, 1, 6};
        int k = -4;
        System.out.println(Arrays.toString(solution.decrypt(arr, k)));
    }

    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k == 0) {
            return ans;
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = fun(i, code, k);
        }
        return ans;
    }

    private int fun(int i, int[] code, int k) {
        if (k < 0) {
            int cur = -k;
            k = k + code.length;
            int sum = 0;
            for (int j = k; j < k + cur; j++) {
                sum += code[(j+i) % code.length];
            }
            
            return sum;
        } else {
            int sum = 0;
            for (int cur = i; cur < i + k; cur++) {
                sum += code[(cur + 1) % code.length];
            }
            return sum;
        }
    }
}
