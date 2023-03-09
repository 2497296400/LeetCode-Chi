package 深度广度遍历问题.组合总和;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(nums, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        DFS(candidates, target, lists, stack,0);
        return lists;


    }

    private static void DFS(int[] candidates, int target, List<List<Integer>> lists, Stack<Integer> stack,int strat) {

        if (target==0) {
            lists.add(new ArrayList<>(stack));
            return;
        }
        for (int i = strat; i < candidates.length; i++) {
            if (candidates[i]<=target) {
                if (stack.size() > 0 && stack.peek() > candidates[i]) {
               continue;
                }
                stack.push(candidates[i]);
                DFS(candidates, target-candidates[i], lists, stack,i);
                stack.pop();
            }
        }
    }

}
