package 各种排序.堆排序;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = {5, 9, 0, 1, -1, -1, -1};
        Test2 test2 = new Test2();
        test2.heapSort(arr);
    }
    
    public void heapSort(int[] arr) {
        int len = arr.length;
       for (int i = 0; i < arr.length; i++) {
           heapMax(arr, i);
       }
        System.out.println(Arrays.toString(arr));
     //   while (len > 0) {
            heapfiy(arr, len);
            System.out.println(Arrays.toString(arr));
       // }
        System.out.println(Arrays.toString(arr));
    }

    private void heapfiy(int[] arr, int len) {
        if (len == 0) {
            return;
        }
        int left = 1;
        int index = 0;
        while (left < len) {
            int targe = (left + 1 < len && arr[left + 1] > arr[left]) ? left + 1 : left;
            targe = arr[targe] > arr[index] ? targe : index;
            if (targe == index) {
                break;
            }
            swap(arr, targe, index);
            index = targe;
            left = targe * 2 + 1;
        }
        System.out.println(Arrays.toString(arr));
        swap(arr, 0, --len);
        heapfiy(arr, len);
    }

    private void heapMax(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
