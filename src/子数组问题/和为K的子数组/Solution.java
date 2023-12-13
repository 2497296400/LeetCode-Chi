package 子数组问题.和为K的子数组;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1,-1,-1,-100,2};
        System.out.println(solution.subarraySum(nums, 2));
    } 

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        hashMap.put(0, 1);
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            sum += hashMap.getOrDefault(curSum - k, 0);
            hashMap.put(curSum, hashMap.getOrDefault(curSum, 0) + 1);
        }
        return sum;
    }
}

