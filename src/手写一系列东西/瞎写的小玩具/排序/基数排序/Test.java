package 手写一系列东西.瞎写的小玩具.排序.基数排序;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 211233, 545, 4, 6, 7, 8, 9, 0};
        Test test = new Test();
        test.radixSorting(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    public void radixSorting(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int maxLevel = 0;
        while (max > 0) {
            max /= 10;
            maxLevel++;
        }
        int[][] bucket = new int[10][nums.length];
        int[] count = new int[10];
        for (int i = 0; i < maxLevel; i++) {
            for (int num : nums) {
                int dig = num / (int) Math.pow(10, i) % 10;
                bucket[dig][count[dig]++] = num;
            }
            for (int index = 0, j = 0; j < bucket.length; j++) {
                for (int k = 0; k < count[j]; k++) {
                    nums[index++] = bucket[j][k];
                }
                count[j] = 0;
            }
        }
    }
}
