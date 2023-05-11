package 每日一题系列.每日一题四月.交换一次的先前排列;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.prevPermOpt1(new int[]{3,2,1})));
    }

    public int[] prevPermOpt1(int[] arr) {
        int[] lastMin = new int[arr.length];
        int n = arr.length - 1;
        lastMin[n] = arr[n];
        for (int i = n; i > 0; i--) {
            lastMin[i - 1] = Math.min(arr[i - 1], lastMin[i]);
        }
        int curIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > lastMin[i + 1]) {
                curIndex = i;
                break;
            }
        }
        if (curIndex == -1) {
            return arr;
        }
        int preIndex = -1;
        int deep = Integer.MAX_VALUE;
        for (int i = n; i > curIndex; i--) {
            if (arr[curIndex] > arr[i]) {
                int preDeep = arr[curIndex] - arr[i];
                if (preDeep <= deep) {
                    deep = preDeep;
                    preIndex = i;
                }
            }
        }
        int temp = arr[preIndex];
        arr[preIndex] = arr[curIndex];
        arr[curIndex] = temp;
        return arr;
    }
}
