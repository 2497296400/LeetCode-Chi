package 周赛.三百零二周赛.数组能形成多少数对;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int []nums={1,3,2,1,3,2,2};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.numberOfPairs(nums)));
    }
    public int[] numberOfPairs(int[] nums) {
        int flag1=0;
        int falg2=0;
        HashMap<Integer, Integer>map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Integer value : map.values()) {
            if((value&1)==0){
                flag1+=value/2;
            }
            else {
                flag1+=value/2;
                falg2++;
            }
        }
        return new int []{flag1,falg2};
    }
}
