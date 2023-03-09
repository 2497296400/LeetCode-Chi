package 周赛.三百零八.收集垃圾的最少总时间;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public  static int curSumTime = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String []garbage={"MMM","PGM","GP"};
        int []travel={3,10};
        solution.garbageCollection(garbage, travel);
        System.out.println(curSumTime);
    }
    public int garbageCollection(String[] garbage, int[] travel) {
        ArrayList<HashMap<Character, Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            char[] chars = s.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (char aChar : chars) {
                map.put(aChar, map.getOrDefault(aChar, 0) + 1);
            }
            arrayList.add(map);
        }
        HashMap<Character, ArrayList<Data>> hashMap = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            HashMap<Character, Integer> map = arrayList.get(i);
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                Character key = entry.getKey();
                Data curData = new Data(i, value);
                if (!hashMap.containsKey(key)) {
                    ArrayList<Data> list = new ArrayList<>();
                    list.add(curData);
                    hashMap.put(key, list);
                } else {
                    ArrayList<Data> list = hashMap.get(key);
                    list.add(curData);
                }
            }
        }
        for (Map.Entry<Character, ArrayList<Data>> entry : hashMap.entrySet()) {
            ArrayList<Data> value = entry.getValue();
            int curMaxIndex = value.get(value.size() - 1).curIndex;
            fun(curMaxIndex, value, travel);
        }
        return curSumTime;
    }

    private void fun(int curMaxIndex, ArrayList<Data> value, int[] travel) {
        for (int i = 0; i < curMaxIndex; i++) {
            curSumTime += travel[i];
        }
        for (Data data : value) {
            curSumTime += data.curSum;
        }
    }
}

class Data {
    int curIndex;
    int curSum;
    public Data(int curIndex, int curSum) {
        this.curIndex = curIndex;
        this.curSum = curSum;
    }
}
