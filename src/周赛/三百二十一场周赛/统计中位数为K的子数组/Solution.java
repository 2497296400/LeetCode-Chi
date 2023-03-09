package 周赛.三百二十一场周赛.统计中位数为K的子数组;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5, 19, 11, 15, 13, 16, 4, 6, 2, 7, 10, 8, 18, 20, 1, 3, 17, 9, 12, 14};
        System.out.println(solution.countSubarrays(arr, 6));
    }

    public int countSubarrays(int[] nums, int k) {
        int curIndex = 0;
        for (int num : nums) {
            if (num == k) {
                break;
            }
            curIndex++;
        }
        int n = nums.length;
        int[] preMin = new int[curIndex];
        int[] preMax = new int[curIndex];
        int[] lastMin = new int[n - curIndex - 1];
        int[] lastMax = new int[n - curIndex - 1];
        int ansPreEq = 0;
        int ansPReMax = 0;
        int ansPreMin = 0;

        int ansLaxEq = 0;
        int ansLaxMax = 0;
        int ansLaxMin = 0;
        for (int i = curIndex - 1; i >= 0; i--) {
            if (nums[i] > k) {
                preMax[i]++;
            } else {
                preMin[i]++;
            }
            if (i > 0) {
                preMin[i - 1] = preMin[i];
                preMax[i - 1] = preMax[i];
            }
        }
        for (int i = curIndex + 1; i < n; i++) {
            if (nums[i] > k) {
                lastMax[i - curIndex - 1]++;
            } else {
                lastMin[i - curIndex - 1]++;
            }
            if (i < n - 1) {
                lastMax[i - curIndex] = lastMax[i - curIndex - 1];
                lastMin[i - curIndex] = lastMin[i - curIndex - 1];
            }
        }
        HashMap<Integer, Integer> pre = new HashMap<>();
        HashMap<Integer, Integer> las = new HashMap<>();
        for (int i = 0; i < preMin.length; i++) {
            pre.put(preMax[i] - preMin[i], pre.getOrDefault(preMax[i] - preMin[i], 0) + 1);
        }
        for (int i = 0; i < lastMin.length; i++) {
            las.put(lastMax[i] - lastMin[i], las.getOrDefault(lastMax[i] - lastMin[i], 0) + 1);
        }
        int ans = 1;
        for (Map.Entry<Integer, Integer> entry : pre.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (las.containsKey(0 - key)) {
                Integer integer = las.get(0 - key);
                ans += integer * value;
            }
            if (las.containsKey(1 - key)) {
                Integer integer = las.get(1 - key);
                ans += integer * value;
            }
        }
        ans += pre.getOrDefault(0, 0) + pre.getOrDefault(1, 0) + las.getOrDefault(0, 0) + las.getOrDefault(1, 0);
        return ans;
    }
}
