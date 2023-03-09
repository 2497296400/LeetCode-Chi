package 深度广度遍历问题.全排列2;

import java.util.*;

import static java.util.Arrays.*;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = new Solution().permuteUnique(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] used = new boolean[nums.length];
        DFS(stack, lists, used, nums);
        return lists;
    }

    private void DFS(Stack<Integer> stack, List<List<Integer>> lists, boolean[] used, int[] nums) {
        if (stack.size() == nums.length) {
            lists.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                stack.push(nums[i]);
                DFS(stack, lists, used, nums);
                stack.pop();
                used[i] = false;
            }
        }
    }
}