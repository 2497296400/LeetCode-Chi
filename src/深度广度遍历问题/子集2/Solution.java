package 深度广度遍历问题.子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int []nums= {1,2,2};
        List<List<Integer>> subsets = new Solution().subsetsWithDup(nums);
        System.out.println(subsets);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>lists=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        Arrays.sort(nums);
        DFS(0,list,lists,nums);
        return lists;
    }
    private void DFS(int begin, List<Integer> list, List<List<Integer>> lists, int[] nums) {
        if(!lists.contains(list)){
            lists.add(new ArrayList<>(list));
        }
        for(int i=begin;i<nums.length;i++){
            list.add(nums[i]);
            DFS(i+1,list,lists,nums);
            list.remove(list.size()-1);
        }
    }
}