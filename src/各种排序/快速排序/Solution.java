package 各种排序.快速排序;


import java.util.Arrays;
import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random random = new Random();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        for (int i = 0; i < 1000; i++) {
            arr[i] = random.nextInt(1000);
        }
        int[] clone = arr.clone();

        int[] a = {1, 2, 3, 5, -1, 20, 1, 1, 1, 1, 1, 1, 2, 32, 3, 5, 5, 123, 11, -1, 1231321, 123};
        Arrays.sort(clone);
        qsotr(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.equals(clone, arr));
    }

    private static void qsotr(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] curIndex = getIndex(nums, left, right);
        qsotr(nums, left, curIndex[0]);
        qsotr(nums, curIndex[1], right);
    }

    private static int[] getIndex(int[] nums, int left, int right) {
        int curMin = left - 1;
        int curMax = right;
        int curIndex = nums[right];
        while (left < curMax) {
            if (nums[left] < curIndex) {
                swap(nums, ++curMin, left++);
            } else if (nums[left] > curIndex) {
                swap(nums, left, --curMax);
            } else {
                left++;
            }
        }
        swap(nums, curMax, right);
        return new int[]{curMin, curMax};
    }

    private static void swap(int[] nums, int left, int r) {
        int temp = nums[left];
        nums[left] = nums[r];
        nums[r] = temp;
    }

    private static int getK(int[] arr, int k) {
        return getK(arr, k, 0, arr.length - 1);
    }

    private static int getK(int[] arr, int k, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int[] curIndex = getIndex(arr, l, r);
        if (curIndex[0] <= k && curIndex[1] >= k) {
            return arr[curIndex[0]];
        }
        if (curIndex[0] > k) {
            return getK(arr, k, l, curIndex[0] -1);
        } else {
            return getK(arr, k, curIndex[1] +1, r);
        }
    }
}
