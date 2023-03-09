package 各种排序.堆排序;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {5, 9, 0, 1, 0, 3, 4, 3, 4, 13, -1, -1, -1, -1};
        Test test = new Test();
        test.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            maxHeap(arr, i);
        }
        System.out.println(Arrays.toString(arr));
        int len = arr.length;
        while (len > 0) {
            heapfiy(arr, len);
            System.out.println(Arrays.toString(arr));
            swap(0, --len, arr);
        }
    }

    private void heapfiy(int[] arr, int len) {
        int curIndex = 0;
        int left = 1;
        while (left < len) {
            int large = left + 1 < len && arr[left + 1] > arr[left] ? left + 1 : left;
            large = arr[large] > arr[curIndex] ? large : curIndex;
            if (large == curIndex) {
                break;
            }
            swap(large, curIndex, arr);
            curIndex = large;
            left = large * 2 + 1;

        }
    }

    private void maxHeap(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(index, (index - 1) / 2, arr);
            index = (index - 1) / 2;
        }
    }

    private void swap(int index, int i, int[] arr) {
        int c = arr[i];
        arr[i] = arr[index];
        arr[index] = c;
    }
}
