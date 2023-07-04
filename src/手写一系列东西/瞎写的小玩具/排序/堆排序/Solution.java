package 手写一系列东西.瞎写的小玩具.排序.堆排序;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 5, 4, 6, 7, 8, 9, 0};
        Solution solution = new Solution();
        solution.heapSort(arr);
    }

    public void heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        System.out.println(Arrays.toString(arr));
        int size = arr.length;
        while (size > 0) {
            heapfily(arr, 0, size);
            swap(arr, 0, --size);
        }
        System.out.println(Arrays.toString(arr));
    }

    private void heapfily(int[] arr, int l, int r) {
        int root = l;
        int left = 2 * root + 1;
        while (left < r) {
            int target = left + 1 < r && arr[left + 1] > arr[left] ? left + 1 : left;
            System.out.println(root + " " + target + " " + left);
            target = arr[target] > arr[root] ? target : root;
            if (target == root) {
                break;
            }
            swap(arr, target, root);
            root = target;
            left = 2 * root + 1;
        }
    }

    private void heapInsert(int[] arr, int root) {
        while (arr[root] > arr[(root - 1) / 2]) {
            swap(arr, root, (root - 1) / 2);
            root = (root - 1) / 2;
        }
    }

    private void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
