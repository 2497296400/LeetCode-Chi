package 精选一百道题.前K个高频词;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        System.out.println(Arrays.toString(solution.topKFrequent(nums, 2)));
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int len = 0;
       ArrayList<Data>arrayList=new ArrayList<>();
       PriorityQueue<Data>priorityQueue=new PriorityQueue<>(new Comparator<Data>() {
           @Override
           public int compare(Data o1, Data o2) {
               return o2.sum-o1.sum;
           }
       });
       int curLen=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Data curData = new Data(entry.getKey(), entry.getValue());
               priorityQueue.add(curData);
        }
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll().var);
        }
        return ans;
    }
}

class Data {
    int var;
    int sum;

    public Data(int var, int sum) {
        this.var = var;
        this.sum = sum;
    }
}
