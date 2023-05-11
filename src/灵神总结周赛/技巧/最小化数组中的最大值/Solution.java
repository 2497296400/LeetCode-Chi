package 灵神总结周赛.技巧.最小化数组中的最大值;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimizeArrayValue(new int[]{3, 7, 1, 6}));
    }

    public int minimizeArrayValue(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int curMin = max;
        int l = 0, r = max;
        while (l < r) {
            int mid = (l + r) / 2;
            if (!toCheck(mid, nums)) {
                l = mid + 1;
            } else {
                curMin = mid;
                r = mid;
            }
        }
        return curMin;
    }

    private boolean toCheck(int mid, int[] nums) {
        long preNeed = 0;
      
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                preNeed += mid - nums[i];
            } else {
                int deep = nums[i] - mid;
                if (preNeed < deep) {
                    return false;
                }
                preNeed -= deep;
            }
        }
        return true;
    }
}
