package 精选一百道题.和为K的子数组;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums={-1,-1,1};
        System.out.println(solution.subarraySum(nums,0));
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer>hashMap=new HashMap<>();
        int sum=0;
        hashMap.put(0,1);
        int curSum=0;
        for (int num : nums) {
            curSum += num;
            sum += hashMap.get(curSum - k) == null ? 0 : hashMap.get(curSum - k);
            hashMap.put(curSum, hashMap.getOrDefault(curSum, 0) + 1);

        }
        return sum;
}
}

