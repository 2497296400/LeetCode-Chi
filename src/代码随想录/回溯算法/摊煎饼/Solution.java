package 代码随想录.回溯算法.摊煎饼;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1};
        pancakeSort(arr, arr.length);
        System.out.println(ans);
    }

    static List<Integer> ans = new ArrayList<>();

    private static void pancakeSort(int[] arr, int n) {
        if (n == 1) {
            return;
        }
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                maxIndex = i;
                max = arr[i];
            }
        }
        reverse(arr, 0, maxIndex);
        ans.add(maxIndex + 1);
        reverse(arr, 0, n - 1);
        ans.add(n);
        pancakeSort(arr, n - 1);
    }

    private static void reverse(int[] arr, int i, int i1) {
        while (i < i1) {
            int temp = arr[i];
            arr[i] = arr[i1];
            arr[i1] = temp;
            i++;
            i1--;
        }
    }
}
