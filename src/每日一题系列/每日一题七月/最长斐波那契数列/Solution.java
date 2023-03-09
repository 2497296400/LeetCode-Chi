package 每日一题系列.每日一题七月.最长斐波那契数列;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50};
        System.out.println(lenLongestFibSubseq(arr));
    }


    public static int lenLongestFibSubseq(int[] arr) {
        int sum = 0;;
        for (int i = 0; i < arr.length - 2; i++) {
            int curIndex;
            int curAns;
            for (int j = i + 1; j < arr.length-1; j++) {
                curAns = 0;
                int nextIndex = arr[j];
                curIndex = arr[i];
                int toGetNum = curIndex + nextIndex;
                int index;
                while ((index =Arrays.binarySearch(arr,j,arr.length,toGetNum))>0) {
                    curIndex = nextIndex;
                    nextIndex = arr[index];
                    toGetNum = curIndex + nextIndex;
                    curAns++;
                }
                sum = Math.max(sum, curAns);
            }

        }
        return sum==0?0:sum + 2;

    }
}
