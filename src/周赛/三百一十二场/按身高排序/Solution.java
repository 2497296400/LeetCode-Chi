package 周赛.三百一十二场.按身高排序;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        ArrayList<Data> arrayList = new ArrayList<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            arrayList.add(new Data(names[i], heights[i]));
        }
        arrayList.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.height - o1.height;
            }
        });
        int len = 0;
        for (Data data : arrayList) {
            ans[len++] = data.name;

        }
        return ans;

    }
}

class Data {
    String name;
    int height;

    public Data(String name, int height) {
        this.name = name;
        this.height = height;
    }
}
