package 手写一系列东西.瞎写的小玩具.排序.归并排序;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 5, 4, 6, 7, 8, 9, 0};
        int[] temp = new int[arr.length];
        Solution solution = new Solution();
        solution.mergeSort(arr, temp, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void mergeSort(int[] arr, int[] temp, int l, int r) {
        if (l < r) {
            int mid = l + ((r - l) >> 1);
            mergeSort(arr, temp, l, mid);
            mergeSort(arr, temp, mid + 1, r);
            merge(arr, temp, l, mid, r);
        }
    }

    private void merge(int[] arr, int[] temp, int l, int mid, int r) {
        System.out.println(Arrays.toString(arr) + "l:" + l + "mid" + mid + "r:" + r);
        int left = l;
        int right = mid + 1;
        int tempStart = l;
        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                temp[tempStart++] = arr[left++];
            } else {
                temp[tempStart++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[tempStart++] = arr[left++];
        }
        while (right <= r) {
            temp[tempStart++] = arr[right++];
        }

        //System.out.println(Arrays.toString(arr)+"copy前"+Arrays.toString(temp) + "l:" + l + "r:" + r);
        System.arraycopy(temp, l, arr, l, r - l + 1);
        // System.out.println(Arrays.toString(arr)+"copy后"+Arrays.toString(temp) + "l:" + l + "r:" + r);
    }
}
