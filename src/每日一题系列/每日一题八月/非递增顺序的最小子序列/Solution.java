package 每日一题系列.每日一题八月.非递增顺序的最小子序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []ints={4,4,7,6,7};
        System.out.println(solution.minSubsequence(ints));
    }
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int curSum=0;
        List<Integer>list=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            curSum+=nums[i];
            sum-=nums[i];
            list.add(nums[i]);
            if(curSum>sum){
                break;
            }
        }
        return list;

    }
}
