package 各种排序.堆排序;

import java.util.Arrays;

public class HeapSort {

    private final int[] arr;
    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int len = arr.length -1;
        int beginIndex = len / 2;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(i, len);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = len; i > 0; i--) {
            swap(0, i);
            maxHeapify(0, i - 1);
            System.out.println(Arrays.toString(arr));
        }
    }
    private void maxHeapify(int index, int len) {
        int lc = (index * 2) + 1;
        int rc = lc + 1;
        int maxc = lc;
        if (lc > len) {
            return;
        }
        if (rc <= len && arr[rc] > arr[lc]) {
            maxc = rc;
        }
        if (arr[maxc] > arr[index]) {
            swap(maxc, index);
            maxHeapify(maxc, len);
        }
    }
    private void swap(int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,9,0,5};

        new HeapSort(arr).sort();
        System.out.println(Arrays.toString(arr));
    }
}
