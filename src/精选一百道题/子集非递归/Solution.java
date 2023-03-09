package 精选一百道题.子集非递归;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int length = lists.size();
            for (int j = 0; j < length; j++) {
                List<Integer> list = new ArrayList<>(lists.get(j));
                list.add(nums[i]);
                lists.add(list);
            }
        }
        return lists;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        DFS(0, nums, list, lists);
        return lists;
    }

    private void DFS(int begin, int[] nums, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        if (list.size() == nums.length) {
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            list.add(nums[i]);
            DFS(i + 1, nums, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
