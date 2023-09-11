package 手写一系列东西.瞎写的小玩具.排序.快速排序;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 5, 4, 6, 7, 8, 9, 0};
        Solution solution = new Solution();
        solution.QuickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        HashMap<Integer, Byte> map = new HashMap<>();
        for (int i = 0; i <  (1 << 30)+1; i++) {
            map.put(i, (byte) 0);
        }
        System.out.println(map.size());
    }

    public void QuickSort(int[] arr, int l, int r) {
        if (l < r) {
            int[] position = getPosition(arr, l, r);
            System.out.println(Arrays.toString(position));
            QuickSort(arr, l, position[0]);
            QuickSort(arr, position[1], r);
        }
    }

    private int[] getPosition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        int target = arr[r];
        while (l < more) {
            if (arr[l] < target) {
                swap(arr, ++less, l++);
            } else if (arr[l] > target) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less, more};
    }

    private void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;

    }
}
