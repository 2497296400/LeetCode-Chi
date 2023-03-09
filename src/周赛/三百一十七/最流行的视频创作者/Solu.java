package 周赛.三百一十七.最流行的视频创作者;

import java.util.*;

public class Solu {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        HashMap<String, Integer> name = new HashMap<>();
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < creators.length; i++) {
            if (map.containsKey(creators[i])) {
                name.put(creators[i], name.getOrDefault(creators[i], 0) + views[i]);
                HashMap<String, Integer> map1 = map.get(creators[i]);
                map1.put(ids[i], map1.getOrDefault(ids[i], 0) + views[i]);
            } else {
                HashMap<String, Integer> cur = new HashMap<>();
                cur.put(ids[i], views[i]);
                map.put(creators[i], cur);
                name.put(creators[i], views[i]);
            }
            Math.max(max, name.get(creators[i]));
        }
        List<String> ln = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : name.entrySet()) {
            if (entry.getValue() == max) {
                ln.add(entry.getKey());
            }
        }
        for (String s : ln) {
            HashMap<String, Integer> map1 = map.get(s);
            long curMax = Integer.MIN_VALUE;
            for (Integer value : map1.values()) {
                curMax = Math.max(curMax, value);
            }
            String temp = "";
            for (Map.Entry<String, Integer> entry : map1.entrySet()) {
               if(entry.getValue()>curMax){
                   temp=entry.getKey();
                   curMax=Math.max(curMax, entry.getValue());
               }else if(entry.getValue()==curMax){
                   temp=temp.compareTo(entry.getKey())<0?temp : entry.getKey();
               }
            }
            List<String>list=new LinkedList<>();
            list.add(s);
            list.add(temp);
            ans.add(list);
        }
        return ans;
    }
}