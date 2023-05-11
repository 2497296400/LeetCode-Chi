package 周赛.三百四十场周赛.第三题;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.minimizeMax(new int[]{3, 4, 2, 3, 2, 1, 2}, 3));
    }

    public int minimizeMax(int[] nums, int p) {
        int r = Arrays.stream(nums).max().getAsInt();
        Arrays.sort(nums);
        int l = 0;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (p <= check(mid, nums)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    private int check(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        while (l < nums.length - 1) {
            if (nums[l + 1] - nums[l] <= target) {
                l++;
                sum++;
            }
            l++;
        }
        return sum;
    }
}
