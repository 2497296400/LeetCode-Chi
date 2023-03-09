package 周赛.三百一十八场.长度为K子数组中的最大和;

import java.util.HashMap;

public class Soluition {
    public static void main(String[] args) {
        Soluition soluition = new Soluition();
        int[] arr = {1,5,4,2,9,9,9};
        System.out.println(soluition.maximumSubarraySum(arr, 3));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        long cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                cur += nums[i];
                map.put(nums[i], i);
            } else {
                Integer curIndex = map.get(nums[i]);
                int first = Math.max(i - k, 0);
                for (int j = first; j < curIndex; j++) {
                    cur -= nums[j];
                    map.remove(nums[j]);
                }
            }
            if (map.size() > k) {
                map.remove(nums[i - k]);
                cur-=nums[i-k];
            }
            if (map.size() == k) {
                sum = Math.max(sum, cur);
            }
        }
        return sum;
    }
}
