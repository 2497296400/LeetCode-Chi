package 周赛.三百二十一场周赛.统计中位数为K的子数组;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,2,1,4,5,6};
        System.out.println(solution.countSubarrays(arr, 4));
    }

    public int countSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int curIndex = 0;
        int curSum = 0;
        map.put(0,1);
        for(int i= 0;i<nums.length;i++){
            if(nums[i]==k){
                curIndex = i;
                break;
            }
            curSum+=(nums[i]>k?1:-1);
            map.put(curSum,map.getOrDefault(curSum,0)+1);
        }
        for(int i = curIndex;i<nums.length;i++){
            curSum+=(nums[i]>=k?1:-1);
            ans+=map.getOrDefault(curSum-1,0);
            ans+=map.getOrDefault(curSum-2,0);
        }
        return ans;
    }
}
