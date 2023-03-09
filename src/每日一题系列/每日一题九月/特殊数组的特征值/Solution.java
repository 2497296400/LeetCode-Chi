package 每日一题系列.每日一题九月.特殊数组的特征值;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 5};
        System.out.println(solution.specialArray(arr));
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < 1000; i++) {
            if(i>nums.length){
                break;
            }
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    if (nums.length - j == i) {
                        return i;
                    }else {
                        break;
                    }
                }
            }
        }
        return -1;
    }
}
