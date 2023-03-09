package 周赛.三百一十三场.公因子的数目;

import java.util.HashSet;

public class Solution {
    public int commonFactors(int a, int b) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                set.add(i);
            }
        }
        int sum = 0;
        for (int i = 1; i <= b; i++) {
            if (b % i == 0) {
                if(set.contains(i)){
                    sum++;
                }
            }
        }
        return sum;
    }
}
