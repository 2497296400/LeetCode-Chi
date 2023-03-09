package 每日一题系列.每日一题七月.数组序号转换;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {100, 100, 100};
        System.out.println(Arrays.toString(solution.arrayRankTransform(ints)));
    }
        public int[] arrayRankTransform(int[] arr) {
            TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (treeMap.containsKey(arr[i])) {
                    ArrayList<Integer>arrayList = treeMap.get(arr[i]);
                    arrayList.add(i);
                }else {
                    ArrayList<Integer>arrayList=new ArrayList<>();
                    arrayList.add(i);
                    treeMap.put(arr[i],arrayList);
                }
            }
            int[] ans = new int[arr.length];
            int curIndex = 1;
            for (ArrayList<Integer> value : treeMap.values()) {
                for (Integer integer : value) {
                    ans[integer]=curIndex;
                }
                curIndex++;
            }
            return ans;
        }
    }