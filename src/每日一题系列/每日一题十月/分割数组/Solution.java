package 每日一题系列.每日一题十月.分割数组;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []arr={5,0,3,8,6};
        System.out.println(solution.partitionDisjoint(arr));
    }
    public int partitionDisjoint(int[] nums) {
        int left = 0;
        int right = nums.length;
        int[] Rmin = new int[nums.length];
        Rmin[nums.length - 1] = nums[nums.length - 1];
        int[] Lmax = new int[nums.length];
        Lmax[0] = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            Rmin[nums.length - i - 2] = Math.min(nums[nums.length - i - 2], Rmin[nums.length - i - 1]);
            Lmax[i + 1] = Math.max(nums[i + 1], Lmax[i]);
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (Rmin[i+1] > Lmax[i]) {
                return i+1;
            }
        }
        return 0;
    }
}
