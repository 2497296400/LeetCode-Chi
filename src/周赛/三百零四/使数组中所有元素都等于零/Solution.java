package 周赛.三百零四.使数组中所有元素都等于零;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int []nums={1,5,0,3,5};
        Solution solution = new Solution();
        System.out.println(solution.minimumOperations(nums));
    }
    public int minimumOperations(int[] nums) {
        int curTimes=0;
        Arrays.sort(nums);
        int curMax=nums[nums.length-1];
        int curData=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                continue;
            }
            int cur=nums[i];
            for(int j=i;j<nums.length;j++){
                nums[j]-=cur;
            }
            curTimes++;
        }
        return curTimes;

    }
}
