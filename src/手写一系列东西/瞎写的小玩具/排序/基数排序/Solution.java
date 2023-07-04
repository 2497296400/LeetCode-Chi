package 手写一系列东西.瞎写的小玩具.排序.基数排序;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 211233, 545, 4, 6, 7, 8, 9, 0};
        Solution solution = new Solution();
        solution.RadixSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void RadixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];
        for (int i = 0, n = 1; i < maxDigit; i++, n *= 10) {
            for (int k : arr) {
                int digit = k / n % 10;
                bucket[digit][bucketCount[digit]++] = k;

            }
            int index = 0;
            for (int j = 0; j < bucket.length; j++) {
                for (int k = 0; k < bucketCount[j]; k++) {
                    arr[index++] = bucket[j][k];
                }
                bucketCount[j] = 0;
            }
        }
    }
}
