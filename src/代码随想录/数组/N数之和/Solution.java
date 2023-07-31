package 代码随想录.数组.N数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> NSum(int[] nums) {
        Arrays.sort(nums);
        List<Integer> collect = Arrays.stream(nums).boxed().toList();
        return NSum(collect, 4, 0, 10);
    }

    private List<List<Integer>> NSum(List<Integer> nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.size();
        if (n < 2 || size < n) {
            return res;
        }
        if (n == 2) {
            res = toSum(nums, start, target);
        } else {
            for (int i = start; i < nums.size(); i++) {
                List<List<Integer>> sub = NSum(nums, n - 1, i + 1, target - nums.get(i));
                for (List<Integer> list : sub) {
                    list.add(nums.get(i));
                    res.add(list);
                }
                while (i < size - 1 && nums.get(i) == nums.get(i + 1)) {
                    i++;
                }
            }
        }
        return res;
    }

    private List<List<Integer>> toSum(List<Integer> nums, int start, int target) {
        int left = start, right = nums.size() - 1;
        List<List<Integer>> asn = new ArrayList<>();
        while (left < right) {
            Integer leftSum = nums.get(left);
            Integer rightSum = nums.get(right);
            int sum = leftSum + rightSum;
            if (sum < target) {
                while (left < right && nums.get(left) == leftSum) {
                    left++;
                }
            } else if (sum > target) {
                while (right > left && nums.get(right) == rightSum) {
                    right--;
                }
            } else {
                asn.add(new ArrayList<>(Arrays.asList(left, right)));
            }
        }
        return asn;
    }
}
