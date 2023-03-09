package 周赛.三百一十九场.最小公倍数为K的子数组数目;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 6, 2, 7, 1};
        System.out.println(solution.subarrayLCM(arr, 6));
    }

    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                ans++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            long sum = first;
            for (int j = i + 1; j < nums.length; j++) {
                long cur = GCD(sum, nums[j]);
                if (sum * nums[j] / cur == k) {
                    ans++;
                } else if (sum > k) {
                    break;
                }
                sum = sum * nums[j] / cur;
            }
        }
        return ans;
    }

    public long GCD(long m, long n) {
        return n == 0 ? m : GCD(n, m % n);
    }
}

