package 精选一百道题.数的和.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> data = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3) {
            return data;
        }
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = nums.length - 1;
            int targe = -nums[first];
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (third > second && nums[second] + nums[third] > targe) {
                    third--;
                }
                if (second == third) {
                    break;

                }
                if (nums[second] + nums[third] == targe) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    data.add(list);
                }
            }
        }
        return data;
    }
}
