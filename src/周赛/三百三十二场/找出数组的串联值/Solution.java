package 周赛.三百三十二场.找出数组的串联值;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheArrayConcVal(new int[]{7, 52, 2, 4}));
    }
    public long findTheArrayConcVal(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        long ans = 0L;
        while (l <= r) {
            ans += getAns(l++, r--, nums);
        }
        return ans;
    }

    private long getAns(int l, int r, int[] nums) {
        if (l == r) {
            return nums[l];
        } else {
            String f = String.valueOf(nums[l]);
            String s = String.valueOf(nums[r]);
            String s1 = f + s;
           return Long.parseLong(s1);
        }
    }
}
