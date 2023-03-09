package 周赛.三百一十七.最流行的视频创作者;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] c = {"a", "a", "a"};
        String[] o = {"a", "b", "c"};
        int[] v = {1000, 1000, 10000};
        System.out.println(solution.mostPopularCreator(c, o, v));
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, HashMap<String, Long>> map = new HashMap<>();
        HashMap<String, Long> name = new HashMap<>();
        long max = 0;
        for (int i = 0; i < creators.length; i++) {
            if (map.containsKey(creators[i])) {
                name.put(creators[i], name.getOrDefault(creators[i], 0L) + views[i]);
                HashMap<String, Long> map1 = map.get(creators[i]);
                map1.put(ids[i], Math.max(map1.getOrDefault(ids[i], 0L), views[i]));
            } else {
                HashMap<String, Long> cur = new HashMap<>();
                cur.put(ids[i], (long) views[i]);
                map.put(creators[i], cur);
                name.put(creators[i], (long) views[i]);
            }
            max = Math.max(max, name.get(creators[i]));
        }
        List<String> ln = new ArrayList<>();
        for (Map.Entry<String, Long> entry : name.entrySet()) {
            if (entry.getValue() == max) {
                ln.add(entry.getKey());
            }
        }
        for (String s : ln) {
            HashMap<String, Long> map1 = map.get(s);
            long curMax = Integer.MIN_VALUE;
            String temp = "";
            for (Map.Entry<String, Long> entry : map1.entrySet()) {
                if (entry.getValue() > curMax || temp.equals("")) {
                    temp = entry.getKey();
                    curMax = Math.max(curMax, entry.getValue());
                } else if (entry.getValue() == curMax) {
                    temp = temp.compareTo(entry.getKey()) < 0 ? temp : entry.getKey();
                }
            }
            List<String> list = new LinkedList<>();
            list.add(s);
            list.add(temp);
            ans.add(list);
        }
        return ans;
    }
}