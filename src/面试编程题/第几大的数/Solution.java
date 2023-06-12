package 面试编程题.第几大的数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 4, 9, 10,18,55,313,513,111};
        Solution solution = new Solution();
        System.out.println(solution.findKh(arr, 4));
    }

    public int findKh(int[] arr, int k) {
        int len = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            heapMax(arr, i);
        }
        // System.out.println(Arrays.toString(arr));
        int ans = arr[0];
        while (len >= 0 && k > 1) {
            heapfly(arr, len);
            if (len + 1 < arr.length && arr[0] != arr[len + 1]) {

                System.out.println(Arrays.toString(arr) + "  " + arr[0] + "  " + arr[len + 1]);
                k--;
            }
            swap(arr, 0, len--);
        }
        System.out.println(Arrays.toString(arr));
        return k == 1 ? arr[len+k] : ans;
    }

    private void heapfly(int[] arr, int index) {
        int root = 0;
        int left = 1;
        while (left <= index) {
            int target = left + 1 <= index && arr[left + 1] > arr[left] ? left + 1 : left;
            target = arr[root] < arr[target] ? target : root;
            if (root == target) {
                break;
            }
            swap(arr, root, target);
            root = target;
            left = root << 1;
        }
    }

    private void heapMax(int[] arr, int index) {
        while (index >= 0 && arr[index] > arr[index >> 1]) {
            swap(arr, index, index >> 1);
            index = index >> 1;
        }
    }

    private void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
