package 周赛.三百二十六.第二题;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distinctPrimeFactors(int[] nums) {
        long cur = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            cur *= num;
            for (int i = 2; i * i <= cur; i++) {
                boolean fal = false;
                while (cur % i == 0) {
                    set.add(i);
                    cur /= i;
                }
            }
        }
        if(cur>1){
            set.add((int) cur);
        }
        return set.size();
    }
}
