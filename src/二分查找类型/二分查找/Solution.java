package 二分查找类型.二分查找;

public class Solution {
    private int start;
    private int end;

    public static int rank(int key, int[] arr, int start, int end) {
        int mid = start + (end - start) / 2;
        if (start > end) {
            return -1;
        }
        if (key > arr[mid]) {
            return rank(key, arr, mid +1, end);
        } else if (key < arr[mid]) {
            return rank(key, arr, start, mid - 1);
        } else {
            return mid;
        }
    }

    public int search(int[] nums, int target) {
        start = 0;
        end = nums.length - 1;
        return rank(target, nums, start, end);
    }
}
