package 各种排序.希尔排序;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int []arr={1,2,5,9,0,1,3};
        System.out.println(Arrays.toString(sort(arr)));
    }
    public static int [] sort(int[] arr) {
        int len = arr.length;
        int gap = 1;
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }
        for (; gap > 0; gap /= 3) {
            for (int i = gap; i < len; i++) {
                int temp = arr[i];
                int j;
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }
        return arr;
    }
}
