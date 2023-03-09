package 每日一题系列.每日一题七月.最小绝对差;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int curMin=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            curMin=Math.min(arr[i]-arr[i-1],curMin);
        }
        List<List<Integer>>lists=new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==curMin){
                List<Integer> list=new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                lists.add(list);
            }
        }
        return lists;
    }
}
