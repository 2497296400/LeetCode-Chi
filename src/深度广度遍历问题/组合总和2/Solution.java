package 深度广度遍历问题.组合总和2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        int targe = 3;
        System.out.println(combinationSum2(nums, targe));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] used = new boolean[candidates.length];
        DFS(candidates, target, lists, stack, 0, used);
        return lists;


    }

    private static void DFS(int[] candidates, int target, List<List<Integer>> lists, Stack<Integer> stack, int start, boolean[] used) {
        if (target == 0) {
            lists.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            if(i>start&&candidates[i]==candidates[i-1]){
                continue;
            }
           // used[i] = true;
            stack.push(candidates[i]);
            DFS(candidates, target - candidates[i], lists, stack, i+1, used);
            //used[i] = false;
            stack.pop();
        }
    }
}
