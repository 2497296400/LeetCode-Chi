package 灵神总结周赛.数据结构.满足不等式的数对数目;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {-2, -2, -1, 2, 4, 1, -4};
        int[] srr = {0, -1, -1, -1, -2, -5, 3};
        System.out.println(solution.numberOfPairs(arr, srr, 4));
    }

    int ans = 0;
    int[] temp;

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int[] arr = new int[nums1.length];
        temp = new int[nums1.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums1[i] - nums2[i];
        }
        System.out.println(Arrays.toString(arr));
        megeSort(arr, 0, arr.length - 1, diff);
        System.out.println(Arrays.toString(arr));
        return ans;
    }

    private void megeSort(int[] arr, int l, int r, int diff) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        megeSort(arr, l, mid, diff);
        megeSort(arr, mid + 1, r, diff);
        mege(arr, l, mid, r, diff);
    }

    private void mege(int[] arr, int l, int mid, int r, int diff) {
        for (int i = l, j = mid + 1; j <= r; j++) {
            while (i <= mid && (arr[i] <= arr[j] + diff)) {
                i++;
            }
            //System.out.println(l + "-- " + i + " " + j );
            //ans += (i - l);
        }
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        for (int c = l; c < k + l; c++) {
            arr[c] = temp[c - l];
        }
    }
}
