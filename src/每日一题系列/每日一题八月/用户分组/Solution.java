package 每日一题系列.每日一题八月.用户分组;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Data> data = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            data.add(new Data(i, groupSizes[i]));
        }
        data.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.curGroupSsm-o2.curGroupSsm;
            }
        });
        int index=0;
        int len=data.size();
        while (index<len){
            int curSum=data.get(index).curGroupSsm;
            List<Integer>list=new ArrayList<>();
            for(int i=0;i<curSum;i++){
                list.add(data.get(index).index);
                index++;
            }
            ans.add(list);
        }
        return ans;
    }
}

class Data {
    int index;
    int curGroupSsm;

    public Data(int index, int curGroupSsm) {
        this.index = index;
        this.curGroupSsm = curGroupSsm;
    }
}
