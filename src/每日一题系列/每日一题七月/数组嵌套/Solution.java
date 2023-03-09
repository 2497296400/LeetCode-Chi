package 每日一题系列.每日一题七月.数组嵌套;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int arrayNesting(int[] nums) {
        int maxLen=0;
        Set<Integer>path=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(path.contains(nums[i])){
                continue;
            }
            Set<Integer>set=new HashSet<>();
            set.add(nums[i]);
            int index=nums[i];
            path.add(index);
            while (!set.contains(nums[index])){
                set.add(nums[index]);
                index=nums[index];
                path.add(index);
            }
            maxLen=Math.max(maxLen,set.size());
            if(maxLen>=nums.length>>1){
                return maxLen;
            }
        }
        return maxLen;
    }
    public int BestArrayNesting(int[] nums) {
        int maxLen=0;
        boolean[]path=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            int sum=0;
            while (!path[i]){
                path[i]=true;
                i=nums[i];
                sum++;
            }
            if(sum>nums.length>>1){
                return sum;
            }
            maxLen=Math.max(maxLen,sum);
        }
        return maxLen;
    }
}
