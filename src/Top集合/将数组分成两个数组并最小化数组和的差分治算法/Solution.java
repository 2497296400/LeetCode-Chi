package Top集合.将数组分成两个数组并最小化数组和的差分治算法;

import java.util.HashMap;
import java.util.TreeSet;

public class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        long sum = 0L;
        for (int num : nums) {
            sum += num;
        }
        HashMap<Integer, TreeSet<Integer>> leftMap = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> rightMap = new HashMap<>();
        process(nums, 0, n / 2, 0, 0, leftMap);
        process(nums, n / 2, n, 0, 0, rightMap);
        long target = sum / 2;
        int ans = Integer.MAX_VALUE;
        for (Integer counts : leftMap.keySet()) {
            for (Integer curSum : leftMap.get(counts)) {
                int lessConuts = n / 2 - counts;
                Integer curAns = rightMap.get(lessConuts).floor((int) (target - curSum));
                if (curAns != null) {
                    int pickSum = curSum + curAns;
                    int restSum = (int) (sum - pickSum);
                    ans = Math.min(ans, Math.abs(restSum - pickSum));
                }
            }
        }
        return ans;
    }

    private void process(int[] nums, int index, int end, int sum, int counts, HashMap<Integer, TreeSet<Integer>> map) {
        if (index == end) {
            if (!map.containsKey(counts)) {
                map.put(counts, new TreeSet<>());
            }
            map.get(counts).add(sum);
        }
        process(nums, index + 1, end, sum, counts, map);
        process(nums, index + 1, end, sum + nums[index], counts + 1, map);
    }
}
