package 代码随想录.数组.N数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2, 3, 4, 5, 1, 1, 1, 1, 1};
        Arrays.sort(nums);
        List<List<Integer>> lists = solution.NSum(nums, 7, 7);
        System.out.println(lists);
    }

    public List<List<Integer>> NSum(int[] nums, int dataSum, int target) {
        if (dataSum == 2) {
            return twoSum(nums, target);
        } else {
            List<List<Integer>> ans = null;
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                List<List<Integer>> lists = NSum(Arrays.copyOfRange(nums, i + 1, nums.length), dataSum - 1, target - nums[i]);
                if (lists != null) {
                    for (List<Integer> list : lists) {
                        list.add(nums[i]);
                    }
                    if (ans == null) {
                        ans = lists;
                    } else {
                        ans.addAll(lists);
                    }
                }
            }
            return ans;
        }
    }

    private List<List<Integer>> twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        List<List<Integer>> ans = null;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                if (ans == null) {
                    ans = new ArrayList<>();
                }
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                ans.add(list);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
