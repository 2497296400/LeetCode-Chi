package 精选一百道题.下一个排列;

import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 2, 0, 2, 3, 2, 0};
        int[] nums1 = {5, 4, 7, 5, 3, 2};
        int[] nums2 = {1, 3, 2};
        int[] nums4={4,8,8,8,9,7,7,6,4,3};
        nextPermutation1(nums2);
    }

    public static void nextPermutation(int[] nums) {
        int cur = nums.length - 1;
        int pre = cur - 1;
        int flag = 0;
        int indxj = 0;
        int indxi = 0;
        int flag2 = 0;
        for (int i = cur; i > indxj; i--) {
            for (int j = i - 1; j >= (flag2==0? indxj : indxj + 1); j--) {
                if (nums[i] > nums[j]) {
                    indxj = j;
                    indxi = i;
                    flag2 = 1;
                }
            }
        }
        int temp = nums[indxi];
        nums[indxi] = nums[indxj];
        nums[indxj] = temp;
        if (flag2 == 0) {
            Arrays.sort(nums);
        } else {
            Arrays.sort(nums, indxj + 1, cur + 1);
        }

        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation1(int []nums){
        int cur=nums.length-2;
        while(cur>=0&&nums[cur]>nums[cur+1]){
            cur--;
        }
        if(cur>=0){
            int index=nums.length-1;
            while (index>=0&&nums[cur]>nums[index]){
                index--;
            }
            swap(nums,cur,index);
        }
        resver(nums,cur+1);
        System.out.println(Arrays.toString(nums));

    }

    private static void resver(int[] nums, int strat) {
        int left=strat;
        int right=nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;

        }
    }

    private static void swap(int[] nums, int cur, int index) {
        nums[cur]^=nums[index];
        nums[index]^=nums[cur];
        nums[cur]^=nums[index];
    }

}
