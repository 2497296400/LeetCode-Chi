package 每日一题系列.每日一题七月.图的类型.重建序列图拓扑排序;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 1, 5, 2, 6, 3};
        int[][] ints = {{5, 2, 6, 3}, {4, 1, 5, 2}};
        System.out.println(solution.sequenceReconstruction(nums, ints));
    }

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
       int []v=new int[nums.length+1];
       int n=nums.length;
       ArrayList<Integer>[]grah= new ArrayList[n+1];
       for(int i=1;i<=n;i++){
           grah[i]=new ArrayList<>();
       }
        for (int[] sequence : sequences) {
            for(int i=0;i<sequence.length-1;i++){
                v[sequence[i+1]]++;
                grah[sequence[i]].add(sequence[i+1]);
            }
        }
        Queue<Integer>zeroQ=new LinkedList<>();
        int pre=0;
        for(int i=1;i<=n;i++){
            if(v[i]==0){
                zeroQ.add(i);
            }
            if(zeroQ.size()>1){
                return false;
            }
        }

        while (!zeroQ.isEmpty()){
            Integer curNode = zeroQ.poll();
            if(nums[pre++]!=curNode){
                return false;
            }
            for (Integer arrayList : grah[curNode]) {
                if(--v[arrayList]==0){
                    zeroQ.add(arrayList);
                }
                if(zeroQ.size()>1){
                    return false;
                }
            }
        }
        return pre==n;
    }
}


