package 各种排序.桶排序;

import java.util.Arrays;

public class Solution {
    public void bucketSort(int[] arr, int N) {
        int[] bucket = new int[N];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        for (int i = 0, j = 0; i < N; i++) {
            while ((bucket[i]--) > 0) {
                arr[j++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 5, 4, 2, 3, 4, 1};
        int max = Arrays.stream(arr).max().getAsInt();
        solution.bucketSort(arr,max+1);
        System.out.println(Arrays.toString(arr));
    }
}
