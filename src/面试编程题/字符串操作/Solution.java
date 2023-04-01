package 面试编程题.字符串操作;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回满足题意的最小操作数
     *
     * @param str string字符串 给定字符串
     * @return int整型
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations("eueyeuvdeoyuveoyvyvecevveocedcddvouvudvuuuoydeucvecdycdodcdcdvecooeecdycycydecuc"));
    }

    public int minOperations(String str) {
        // write code here
        int ans = 0;
        char[] arr = str.toCharArray();
        int[] srr = new int[26];
        for (char c : arr) {
            srr[c - 'a']++;
        }
        int curSum = 0;
        for (int c : srr) {
            if (c == 0) {
                curSum++;
            }
        }
        int pre = 0;
        for (int i = 0; i < srr.length; i++) {
            if (srr[i] == 2) {
                pre++;
            }
            if (srr[i] > 2) {
                if (curSum == 0) {
                    ans += srr[i] - 1;
                } else {
                    int need = (srr[i] - 1) / 2;
                    if (curSum >= need) {
                        curSum -= need;
                        ans += srr[i] - 1 - need;
                    } else {
                        ans += srr[i] - 1 - curSum;
                        curSum = 0;
                    }
                }
            }
        }
        return ans+pre;
    }
}
