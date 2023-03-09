package 深度广度遍历问题.全排列;

import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, path, used, res);
     return  res;
    }
    private  void  dfs(int[] nums, int len, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(path.size()==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j=0; j < len; j++) {
           if(used[j]) {
                continue;
           }
            path.addLast(nums[j]);
            used[j]=true;
            System.out.println("递归前："+path+"判断"+ Arrays.toString(used)+j);
            dfs(nums,len,path,used,res);
            path.removeLast();
            used[j]=false;
            System.out.println("递归后："+path+"判断"+ Arrays.toString(used)+j);
        }
    }
}

