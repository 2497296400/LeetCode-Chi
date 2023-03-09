package 精选一百道题.数的和.两数之和;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []keyNumbers=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(target-nums[i],i);
            if(map.containsKey(nums[i])&&i!=map.get(nums[i])){
                keyNumbers[0]=map.get(nums[i]);
                keyNumbers[1]=i;
                break;
            }
        }
        return  keyNumbers;
    }
}
