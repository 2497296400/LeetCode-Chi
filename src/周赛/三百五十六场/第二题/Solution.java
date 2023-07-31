package 周赛.三百五十六场.第二题;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countCompleteSubarrays(new int[]{1898, 370, 822, 1659, 1360, 128, 370, 360, 261, 1898}));

    }

    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        HashMap<Integer, Integer> nextSet = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        while (right < nums.length) {
            nextSet.put(nums[right], nextSet.getOrDefault(nums[right++], 0) + 1);
            while (nextSet.size() == set.size()) {
                ans += nums.length - right + 1;
                if (nextSet.get(nums[left]) == 1) nextSet.remove(nums[left]);
                else nextSet.put(nums[left], nextSet.get(nums[left]) - 1);
                left++;
            }
        }
        return ans;
    }
}
