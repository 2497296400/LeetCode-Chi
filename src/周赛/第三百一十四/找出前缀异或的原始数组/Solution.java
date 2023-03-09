package 周赛.第三百一十四.找出前缀异或的原始数组;

public class Solution {
    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            ans[i] = pref[i - 1] ^ pref[i];
        }
        return ans;
    }
}
