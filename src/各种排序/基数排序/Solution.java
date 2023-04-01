package 各种排序.基数排序;

import java.util.Arrays;

public class Solution {
    public void countSort(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] bucket = new int[10];
        for (int i = 0; i < arr.length; i++) {
            bucket[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            bucket[i] += bucket[i - 1];
        }
        for (int i = arr.length-1; i>=0; i--) {
            output[bucket[(arr[i] / exp) % 10] - 1] = arr[i];
            bucket[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {111, 555, 1, 0, 3, 5456, 23, 112};
        solution.getSort(arr);
    }
    public void  getSort(int [] arr){
        int anInt = Arrays.stream(arr).max().getAsInt();
        for(int exp = 1;exp<anInt;exp*=10){
            countSort(arr,exp);
        }
        System.out.println(Arrays.toString(arr));
    }
}
