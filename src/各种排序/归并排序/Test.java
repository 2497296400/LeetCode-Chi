package 各种排序.归并排序;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {11, 44, 23, 67, 88, 65, 34, 48, 9, 12};
        Sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void Sort(int[] arr) {
        int[] temp = new int[arr.length];
        megeSort(arr, temp, 0, arr.length - 1);
    }

    private static void megeSort(int[] arr, int[] temp, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            megeSort(arr, temp, l, mid);
            megeSort(arr, temp, mid + 1, r);
            mege(arr, temp, l, mid, r);
        }
    }

    private static void mege(int[] arr, int[] temp, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        for (int cur = 0; cur < k; cur++) {
            arr[cur + l] = temp[cur];
        }
    }

}
