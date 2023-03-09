package 每日一题系列.每日一题一月.查找用户活跃分钟数;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        HashMap<Integer, HashSet> map = new HashMap<>();
        for (int[] log : logs) {
            int f = log[0];
            int s = log[1];
            if (!map.containsKey(f)) {
                map.put(f, new HashSet<>());
            }
            map.get(f).add(s);
        }
        for (HashSet value : map.values()) {
            ans[value.size() - 1]++;
        }
        return ans;
    }
}
