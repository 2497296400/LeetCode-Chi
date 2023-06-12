package 左神算法集.二分找到第几个数对;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 5, 6, 41, 8, 6, 1, 2};
        System.out.println(solution.getMathDui(arr, 20));
        System.out.println(solution.pro(arr, 20));
    }


    public int pro(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n * (n - 1) / 2];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                arr[len++] = Math.abs(nums[i] -nums[j]);
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public int getMathDui(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int curSumDui = n * (n - 1) / 2;
        int r = nums[n - 1] - nums[0];
        int l = 0;
        int curAns = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (getSum(nums, mid) <=k) {
                curAns = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return curAns+1;
    }

    private int getSum(int[] nums, int target) {
        int sum = 0;
        for (int l = 0, r = 1; l < nums.length ; r=Math.max(r, ++l)) {
            while (r<nums.length&&nums[r]-nums[l]<=target){
                r++;
            }
            sum+=r-l-1;
        }
        return sum;
    }
}
