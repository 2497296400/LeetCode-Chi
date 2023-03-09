package 每日一题系列.每日一题八月.设计有序流;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
}

class OrderedStream {
    private int prt;
    public int capacity;
    int[] map;
    private HashMap<Integer, String> hashMap;

    public OrderedStream(int n) {
        prt = 1;
        capacity = n;
        map = new int[n + 1];
        hashMap = new HashMap<>();
    }
    public List<String> insert(int idKey, String value) {
        map[idKey] = 1;
        List<String> ans = new ArrayList<>();
        hashMap.put(idKey, value);
        while (prt < map.length && map[prt] != 0) {
            ans.add(hashMap.get(prt));
            prt++;
        }
        return ans;
    }
}