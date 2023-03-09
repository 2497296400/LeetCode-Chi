package 周赛.三百二十二场.划分技能点相等的团队;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dividePlayers(new int[]{2, 1, 5, 2}));
    }

    public long dividePlayers(int[] skill) {
        long sum = 0;
        HashMap<Integer, Integer> fmap = new HashMap<>();
        HashMap<Integer, Integer> smap = new HashMap<>();
        for (int i : skill) {
            sum += i;
            fmap.put(i, fmap.getOrDefault(i, 0) + 1);
            smap.put(i, smap.getOrDefault(i, 0) + 1);
        }
        int len = skill.length;
        if (sum % (len / 2) != 0) {
            return -1;
        }
        int target = (int) (sum / (len / 2));
        long ans = 0;
        int s = 0;
        for (int cur : skill) {
            if (fmap.containsKey(cur)) {
                if (fmap.get(cur) == 1) {
                    fmap.remove(cur);
                } else {
                    fmap.put(cur, fmap.get(cur) - 1);
                }
                if (fmap.containsKey(target - cur)) {
                    if (fmap.get(target - cur) == 1) {
                        fmap.remove(target - cur);
                    } else {
                        fmap.put(target - cur, fmap.get(target - cur) - 1);
                    }
                } else {
                    return -1;
                }
                ans += (long) cur * (target - cur);
            }
        }
        if (fmap.size() == 0) {
            return ans;
        } else {
            return -1;
        }
    }
}
