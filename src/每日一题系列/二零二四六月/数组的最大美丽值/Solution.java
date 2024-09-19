package 每日一题系列.二零二四六月.数组的最大美丽值;

import java.util.Arrays;

public class Solution {
    public int maximumBeauty(int[] arr, int k) {
        Arrays.sort(arr);
        int ans = 0;
        if (arr.length == 1) {
            return 1;
        }
        int l = 0, r = 1;
        while (r < arr.length) {
            if (arr[r] - arr[l] <= 2 * k) {
                ans = Math.max(ans, r - l + 1);
                r++;
            } else {
                l++;
            }
        }
        return ans;
    }
}
