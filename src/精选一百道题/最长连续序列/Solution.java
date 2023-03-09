package 精选一百道题.最长连续序列;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] byns = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maxlen = 0;
        for (int i = 0; i < nums.length; i++) {
            int leftlen = 0, ringtlen = 0;
            int curlen = 0;
            if (!hashMap.containsKey(nums[i])) {
                leftlen = hashMap.getOrDefault(nums[i] - 1, 0);
                ringtlen = hashMap.getOrDefault(nums[i] + 1, 0);
                curlen = leftlen + ringtlen + 1;
                maxlen = Math.max(maxlen, curlen);
                hashMap.put(nums[i], curlen);
                if (leftlen != 0) {
                    hashMap.put(nums[i] - leftlen, curlen);
                }
                if (ringtlen != 0) {
                    hashMap.put(nums[i] + ringtlen, curlen);
                }
            }
        }
        return maxlen;
    }
}
