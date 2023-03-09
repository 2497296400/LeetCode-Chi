package 每日一题系列.每日一题一月.得到新鲜甜甜圈的最多组数;

import java.util.HashMap;

public class Solution {
    HashMap<Long, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 2, 5, 2, 2, 1, 6};
        System.out.println(solution.maxHappyGroups(4, arr));
    }

    public int maxHappyGroups(int batchSize, int[] groups) {
        long status = 0L;
        int ans = 0;
        for (int group : groups) {
            int cur = group % batchSize;
            if (cur == 0) {
                ans++;
            } else {
                status += 1L << (cur * 5);
            }
        }
        ans += fun(batchSize, 0, status);
        return ans;
    }

    private int fun(int batchSize, int preLast, Long status) {
        int ans = 0;
        if (map.containsKey(status)) {
            return map.get(status);
        }
        for (int i = 1; i < batchSize; i++) {
            if (((status >> (i * 5)) & 31) > 0) {
                ans = Math.max(ans, fun(batchSize, (preLast + i) % batchSize, status - (1L << (i * 5))) + (preLast == 0 ? 1 : 0));
            }
        }
        map.put(status, ans);
        return ans;
    }
}