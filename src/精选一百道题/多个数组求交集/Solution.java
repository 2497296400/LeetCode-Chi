package 精选一百道题.多个数组求交集;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int [][]nums={{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        System.out.println(intersection(nums));
    }
    public static List<Integer> intersection(int[][] nums) {
        TreeMap<Integer, Integer> hashMap = new TreeMap<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                hashMap.put(nums[i][j], hashMap.getOrDefault(nums[i][j], 0) + 1);
            }
        }
        List<Integer>list=new ArrayList<>();
        for (Integer integer : hashMap.keySet()) {
            if(hashMap.get(integer)==nums.length){
                list.add(integer);
            }
        }
        return list;
    }
}
