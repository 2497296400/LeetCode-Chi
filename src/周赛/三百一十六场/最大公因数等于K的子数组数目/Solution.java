package 周赛.三百一十六场.最大公因数等于K的子数组数目;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []arr={9,3,1,2,6,3};
        System.out.println(solution.subarrayGCD(arr, 3));
    }
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                ans++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int cur = GCD(first, nums[j]);
                if (cur == k) {
                    ans++;
                }
                if (cur < k) {
                    break;
                }
                first = cur;
            }
        }
        return ans;
    }
    public int GCD(int m, int n) {
        return n == 0 ? m : GCD(n, m%n);
    }
}
