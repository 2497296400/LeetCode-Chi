package 每日一题系列.每日一题一月.统计一个数组中好对子的数目;

import java.util.HashMap;

public class Solution {
    public static int MOD = (int) (1e9 + 7);

    public int countNicePairs(int[] nums) {
        int[] afterP = toFun(nums);
        int[] Sub = new int[afterP.length];
        for (int i = 0; i < nums.length; i++) {
            Sub[i] = nums[i] - afterP[i];
        }
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i : Sub) {
            map.put(i, map.getOrDefault(i, 0L) + 1);
        }
        long curSum = 0;
        for (Long value : map.values()) {
            curSum +=(((long) value *(value-1))/2+MOD)%MOD;
        }
        return (int) curSum;
    }

    private int[] toFun(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int curData = nums[i];
            int cur = 0;
            while (curData != 0) {
                int first = curData % 10;
                cur = cur * 10 + first;
                curData /= 10;
            }
            ans[i] = cur;
        }
        return ans;
    }
}
