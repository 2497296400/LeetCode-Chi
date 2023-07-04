package 手写一系列东西.瞎写的小玩具.排序.桶排序;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 5, 4, 6, 7, 8, 9, 0};
        Solution solution = new Solution();
        solution.BucketSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void BucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int[] bucket = new int[max - min + 1];
        for (int i : arr) {
            bucket[i - min]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }
}
