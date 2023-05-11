package 周赛.三百四十场周赛.第二题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.distance(new int[]{1, 3, 1, 1, 2})));
    }

    public long[] distance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        long[] ans = new long[nums.length];
        for (ArrayList<Integer> value : map.values()) {
            if (value.size() > 1) {
                toGetAns(value, ans);
            }
        }
        return ans;
    }

    private void toGetAns(ArrayList<Integer> value, long[] ans) {
        int[] arr = new int[value.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value.get(i);
        }
        int n = arr.length;
        int max = arr[n - 1];
        long sum = 0;
        for (int i = n - 2; i >= 0; i--) {
            sum += max - arr[i];
        }
        ans[max] = sum;
        for (int i = n - 2; i >= 0; i--) {
            long cur = max - arr[i];
            int nextSum = n - i - 2;
            sum = ans[arr[i]] = sum - cur * i + cur * nextSum;
            max = arr[i];
        }
    }
}
