package 周赛.三百二十五自己傻逼场.第三题二分答案法;

import java.util.Arrays;

public class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int high = (int) 1e9;
        int low = 0;
        int ans = 0;
        while (low < high) {
            int cnt = 1;
            int curIndex = 0;
            int mid = (low + high) / 2;
            for (int i = 0; i < price.length; i++) {
                if (price[i] - price[curIndex] >= mid) {
                    curIndex = i;
                    cnt++;
                }
            }
            if (cnt < k) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return high;
    }
}
