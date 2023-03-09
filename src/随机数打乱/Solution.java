package 随机数打乱;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    int[] nums;
    int[] shufle;

    public Solution(int[] nums) {
        this.nums = nums;
        this.shufle = new int[nums.length];
        System.arraycopy(nums, 0, shufle, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(shufle, 0, nums, 0, nums.length);
        return nums;

    }
    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;

    }
}
