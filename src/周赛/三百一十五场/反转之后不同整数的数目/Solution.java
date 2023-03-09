package 周赛.三百一十五场.反转之后不同整数的数目;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {
            1, 13, 10, 12, 31
        } ;
        System.out.println(solution.countDistinctIntegers(arr));
    }

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            set.add(fun(num));
        }
        return set.size();
    }

    private Integer fun(int num) {
        int base = 0;
        while (num != 0) {
            base = base * 10 + num % 10;
            num /= 10;
        }
        return base;
    }
}
