package 面试编程题.第几大的数;

import java.util.Arrays;

public class QuickSolution {
    public static void main(String[] args) {
        QuickSolution quickSolution = new QuickSolution();
        int[] arr = {5,5,3,4,5};
        System.out.println(quickSolution.findK(arr, 5));
    }

    private int findK(int[] arr, int k) {
        int ans = findK(arr, k - 1, 0, arr.length - 1);
        return ans == -1 ? Arrays.stream(arr).max().getAsInt() : ans;
    }

    private int findK(int[] arr, int k, int l, int r) {
        int[] index = getIndex(arr, l, r);
        if (index[0] >= k && index[0] <= k) {
            return arr[index[0]];
        }
        if (l == r) {
            return -1;
        }
        if (index[0] > k) {
            return findK(arr, k, l, index[0] - 1);
        } else {
            return findK(arr, k, index[1] + 1, r);
        }
    }

    private int[] getIndex(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        int target = arr[r];
        while (l < more) {
            if (arr[l] > target) {
                swap(arr, ++less, l++);
            } else if (arr[l] < target) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less+1, more};
    }

    private void swap(int[] arr, int f, int s) {
        int tmep = arr[f];
        arr[f] = arr[s];
        arr[s] = tmep;
    }
}