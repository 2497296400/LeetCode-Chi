package 周赛.三百零二周赛.数位和相等数对的最大和;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums={18,43,36,13,7,63};
        System.out.println(solution.maximumSum(nums));
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue> map=new HashMap<>();
        for (int num : nums) {
            PriorityQueue<Integer>queue=new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            int temp=fun(num);
            if(!map.containsKey(temp)){
                queue.add(num);
                map.put(temp,queue);
            }else {
                queue=map.get(temp);
                queue.add(num);
                map.put(temp,queue);
            }
        }
        int max=-1;
        for (PriorityQueue queue : map.values()) {
            int sum=0;
            if(queue.size()>=2){
                 sum= (int) queue.poll();
                sum+=(int)queue.poll();
            }
            max=Math.max(max,sum);
        }
        return max;
    }
    private int fun(int num) {
        int sum=0;
        while (num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;

    }
}
