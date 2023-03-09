package 精选一百道题.多数元素;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        int count=1;
        int ret=nums[0];
       for(int i=1;i<nums.length;i++){
           if(ret!=nums[i]){
               count--;
           }
           if(count==0){
               ret=nums[i];
           }
               count++;
       }
       return  ret;
  }
}
