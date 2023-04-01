package 每日一题系列.每日一题三月.使数组和能被P整除;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {6, 3, 5, 2};
        System.out.println(solution.minSubarray(arr, 9));
    }

    public int minSubarray(int[] nums, int p) {
        long sum = 0L;
        for (int num : nums) {
            sum += num;
        }
        int cur = (int) (sum % p);
        if (cur == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        sum = 0L;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int res = (int) ((sum - cur + p) % p);
            if (map.containsKey(res)) {
                ans = Math.min(ans, i - map.get(res));
            }
            map.put((int) (sum % p), i);
        }
        return ans>=nums.length? -1 : ans;
    }
}
