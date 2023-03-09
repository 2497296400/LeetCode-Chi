package 周赛.七十三周.找数;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer>map=new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==key){
                map.put(nums[i+1],map.getOrDefault(nums[i+1],0)+1);
            }
        }
        int max=0;
        int result=0;
        TreeMap <Integer,Integer>shortmap = new TreeMap<>(map);
        System.out.println(shortmap.lastKey());
        for(var i :map.keySet()){
           if(map.get(i)>max){
               max=map.get(i);
               result=i;
           }
        }
        return  result;
    }
}