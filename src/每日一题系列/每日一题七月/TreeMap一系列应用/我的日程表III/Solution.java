package 每日一题系列.每日一题七月.TreeMap一系列应用.我的日程表III;

import java.util.TreeMap;

public class Solution {


}
class MyCalendarThree {
    TreeMap<Integer, Integer>map;
    public MyCalendarThree() {
        map=new TreeMap<>();
    }
    public int book(int start, int end) {
        int ans=0;
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int sum=0;
        for (Integer value : map.values()) {
            ans=Math.max(ans,sum);
            sum+=value;
        }
        return ans;

    }
}
