package 周赛.三百二十八场.第三题;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 1, 3, 2, 3, 3, 3, 1, 1, 3, 2, 2, 2};
        System.out.println(solution.countGood(arr, 18));
    }

    public long countGood(int[] nums, int k) {
        long sum = 0L;
        HashMap<Integer, Long> dataSum = new HashMap<>();
        HashMap<Integer, Long> indexMap = new HashMap<>();
        int l = 0;
        int r = 0;
        long cur = 0L;
        for (int i = 0; i < nums.length; i++) {
            if (dataSum.containsKey(nums[i])) {
                dataSum.put(nums[i], dataSum.get(nums[i]) + 1); 
                indexMap.put(i, dataSum.get(nums[i]) - 1);
            } else {
                dataSum.put(nums[i], 1L);
                indexMap.put(i, 0L);
            }
            cur += indexMap.get(i);
            while (cur >= k) {
                sum++;
                cur -= (dataSum.get(nums[l]) - 1);
                dataSum.put(nums[l], dataSum.get(nums[l]) - 1);
                l++;
                sum += nums.length - i - 1;
            }
        }
        return sum;
    }
}
