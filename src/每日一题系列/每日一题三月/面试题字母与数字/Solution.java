package 每日一题系列.每日一题三月.面试题字母与数字;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"2", "3", "4", "E", "5", "F", "G", "6", "7", "H"};
        System.out.println(Arrays.toString(solution.findLongestSubarray(arr)));
    }

    public String[] findLongestSubarray(String[] array) {
        int preSum = 0;
        HashMap<Integer, Integer> digMap = new HashMap<>();
        digMap.put(0, -1);
        int strat = 0;
        int end = 0;
        int ans = Integer.MIN_VALUE;
        int digPre = 0;
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i].charAt(0))) {
                digPre++;
            } else {
                digPre--;
            }
            if (digMap.containsKey(digPre)) {
                Integer curIndex = digMap.get(digPre);
                if (i - curIndex + 1 > ans) {
                    ans = i - curIndex + 1;
                    strat = curIndex + 1;
                    end = i;
                }
            }
            digMap.putIfAbsent(digPre,i);
        }
        return Arrays.copyOfRange(array, strat, end);
    }
}
