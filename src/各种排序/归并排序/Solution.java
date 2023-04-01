package 各种排序.归并排序;


import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {-1,-5,11, 44, 23, 67, 88, 65, 34, 48, 9, 12};
        Sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void Sort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
    }
    private static void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, temp, left, mid);
            mergeSort(nums, temp, mid + 1, right);
            mergeSortArray(nums, temp, left, mid, right);
        }
    }
    private static void mergeSortArray(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int i1 = 0; i1 < k; i1++) {
            nums[left + i1] = temp[i1];
        }
    }
}
