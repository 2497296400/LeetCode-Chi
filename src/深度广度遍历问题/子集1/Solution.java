package 深度广度遍历问题.子集1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int []nums={1,2,3};
        List<List<Integer>> subsets = new Solution().subsets(nums);
        System.out.println(subsets);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        DFS(0, nums, list, lists);
        return lists;
    }
    int flag=0;
    private void DFS(int begin, int[] nums, List<Integer>list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        if (list.size() == nums.length) {
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            list.add(nums[i]);
            DFS(i+1,nums,list,lists);
            list.remove(list.size()-1);
        }
    }
}
